package org.codejudge.sb.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codejudge.sb.enumTypes.LocationType;
import org.codejudge.sb.enumTypes.Status;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "LEAD")
@NoArgsConstructor
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "location_type")
    private LocationType location_type;

    @Column(name = "location_string")
    private String location_string;

    @Column(name = "status")
    private Status status;

    @Column(name = "communication")
    private String communication;

    public Lead(String first_name, String last_name, String mobile, String email, LocationType location_type, String location_string, Status status) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile = mobile;
        this.email = email;
        this.location_type = location_type;
        this.location_string = location_string;
        this.status = status;
    }
}
