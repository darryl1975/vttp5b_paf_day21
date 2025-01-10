package sg.edu.nus.iss.vttp5b_paf_day21.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;

    private String first_name;

    private String last_name;

    private String email;

    private String job_title;

    private String department;

    private Date employement_date;

    private float salary;
}
