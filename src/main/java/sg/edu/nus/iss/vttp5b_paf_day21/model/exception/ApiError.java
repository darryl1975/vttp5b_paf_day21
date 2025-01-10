package sg.edu.nus.iss.vttp5b_paf_day21.model.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private int status;
    private String message;
    private Date timeStamp;  
    private String url;  
}
