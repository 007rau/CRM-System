package org.codejudge.sb.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.entities.Lead;
import org.codejudge.sb.enumTypes.LocationType;
import org.codejudge.sb.enumTypes.Status;
import org.codejudge.sb.repositories.LeadRepository;
import org.codejudge.sb.request.LeadRequest;
import org.codejudge.sb.request.StatusRequest;
import org.codejudge.sb.response.ErrorResponse;
import org.codejudge.sb.response.LeadResponse;
import org.codejudge.sb.response.Response;
import org.codejudge.sb.response.UpdateResponse;
import org.codejudge.sb.validation.LeadValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private LeadValidation leadValidation;

    public Response createLead(LeadRequest leadRequest) {
        log.info("Request payload {}", leadRequest.toString());
        if (leadValidation.isValid(leadRequest)) {
            log.info("valid request");
            Lead lead = new Lead(leadRequest.getFirst_name(), leadRequest.getLast_name(), leadRequest.getMobile(), leadRequest.getEmail(), LocationType.valueOf(leadRequest.getLocation_type()), leadRequest.getLocation_string(), Status.Created);
            Lead savedLead = leadRepository.save(lead);
            BigDecimal mobile = new BigDecimal(savedLead.getMobile());
            return new LeadResponse(savedLead.getFirst_name(), savedLead.getLast_name(),
                    mobile, savedLead.getEmail(), savedLead.getLocation_type().toString(),
                    savedLead.getLocation_string(), savedLead.getStatus().toString());
        }
        return new ErrorResponse("failure", "Invalid Data");
    }

    public Response getLead(int id) {
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if (optionalLead.isPresent()) {
            Lead lead = optionalLead.get();
            BigDecimal mobile = new BigDecimal(lead.getMobile());
            return new LeadResponse(lead.getFirst_name(), lead.getLast_name(),
                    mobile, lead.getEmail(), lead.getLocation_type().toString(), lead.getLocation_string(), lead.getStatus().toString());
        }
        return new Response();
    }

    public Response updateLead(int id, LeadRequest leadRequest) {
        log.info("Request payload {}", leadRequest.toString());
        if (leadRequest.getMobile() != null && leadRequest.getMobile().length() == 10) {
            log.info("valid request");
            Optional<Lead> optionalLead = leadRepository.findById(id);
            if (optionalLead.isPresent()) {
                Lead lead = optionalLead.get();
                lead.setFirst_name(leadRequest.getFirst_name());
                lead.setLast_name(leadRequest.getLast_name());
                lead.setMobile(leadRequest.getMobile());
                lead.setEmail(leadRequest.getEmail());
                lead.setLocation_type(LocationType.valueOf(leadRequest.getLocation_type()));
                leadRequest.setLocation_string(leadRequest.getLocation_string());
                leadRepository.save(lead);
                return new UpdateResponse("success");
            }
            return new ErrorResponse("failure", "Lead Not Found");
        }
        return new ErrorResponse("failure", "Invalid Data");
    }

    public Response deleteLead(int id) {
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if (optionalLead.isPresent()) {
            leadRepository.deleteById(optionalLead.get().getId());
            return new UpdateResponse("success");
        }
        return new ErrorResponse("failure", "Lead Not Found");
    }

    public Response updateLeadStatus(int id, StatusRequest statusRequest) {
        log.info("Request payload {}", statusRequest.toString());
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if (optionalLead.isPresent() && statusRequest.getCommunication() != null) {
            Lead lead = optionalLead.get();
            lead.setCommunication(statusRequest.getCommunication());
            lead.setStatus(Status.Contacted);
            leadRepository.save(lead);
            return new UpdateResponse("success");
        }
        return new ErrorResponse("failure", "Lead Not Found");
    }
}
