package org.codejudge.sb.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codejudge.sb.enumTypes.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeadRequest {
    private String first_name;
    private String last_name;
    private String mobile;
    private String email;
    private String location_type;
    private String location_string;
    private Status status;
}
