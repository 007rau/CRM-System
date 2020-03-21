package org.codejudge.sb.validation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.codejudge.sb.entities.Lead;
import org.codejudge.sb.enumTypes.LocationType;
import org.codejudge.sb.repositories.LeadRepository;
import org.codejudge.sb.request.LeadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class LeadValidation {

    @Autowired
    private LeadRepository leadRepository;

    public boolean isValid(LeadRequest leadRequest) {
        if (leadRequest.getMobile() != null && leadRequest.getMobile().length() == 10 && leadRequest.getFirst_name() != null && leadRequest.getLast_name() != null && leadRequest.getEmail() != null) {
            Optional<Lead> optionalLeadByEmail = leadRepository.findByEmail(leadRequest.getEmail());
            //log.info("Email data : {}", optionalLeadByEmail.get().toString());
            Optional<Lead> optionalLeadByMobile = leadRepository.findByMobile(leadRequest.getMobile());
            //log.info("Mobile data: {}", optionalLeadByMobile.get().toString());
            boolean validEnum = EnumUtils.isValidEnum(LocationType.class, leadRequest.getLocation_type());
            //log.info("valid enum : {}" + validEnum);
            if (optionalLeadByEmail.isPresent() || optionalLeadByMobile.isPresent() || !validEnum) {
                return false;
            }
            return true;
        }
        return false;
    }
}
