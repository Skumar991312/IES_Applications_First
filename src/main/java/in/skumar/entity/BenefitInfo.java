package in.skumar.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity(name="BenefitInfo_Details")
public class BenefitInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer benefitId;
	private String benefitMonthYear;
	private Integer benefitAmt;
	private LocalDate transctionDate;
	private String transctionStatus;


}
