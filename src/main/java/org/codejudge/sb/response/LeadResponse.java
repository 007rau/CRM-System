package org.codejudge.sb.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeadResponse extends Response {
    private String first_name;
    private String last_name;
    private BigDecimal mobile;
    private String email;
    private String location_type;
    private String location_string;
    private String status;
}
