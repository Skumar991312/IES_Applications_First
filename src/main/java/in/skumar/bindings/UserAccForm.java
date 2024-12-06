package in.skumar.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserAccForm {

	private String username;
	private String email;
    private String gender;
    private Long mobaileNo;
    private Long ssn;
    private LocalDate dob;
    private String activeSw;
    private Integer roleId;


}
