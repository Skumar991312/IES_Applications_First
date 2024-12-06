package in.skumar.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name="ED_EGIB_Details")
public class EgibilityDetermination {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer edTraceId;
	private String planName;
	private String planStatus;
	private LocalDate eligStartDate;
	private LocalDate eligEnddate;
	private Integer benefitAmt;
	private String denialReason;

	@CreationTimestamp
	private LocalDate createDate;

	@OneToOne
	@JoinColumn(name="case_Num")
	@JsonBackReference
	private CitizenAppEntity cedNum;

	@OneToOne
	@JsonBackReference
	private COEntity eliTrNo;
}
