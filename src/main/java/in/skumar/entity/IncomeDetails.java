package in.skumar.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Dc_Income")
public class IncomeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer incomeId;
	private Integer monthlySalaryIncome;
	private Integer rentIncome;
	private Integer propertyIncome;

	@OneToOne
	@JoinColumn(name="case_Num")
	@JsonBackReference
	private CitizenAppEntity ciNum;
}
