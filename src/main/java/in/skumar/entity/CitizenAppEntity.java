package in.skumar.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="Citizen_Details")
@ToString
public class CitizenAppEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseNum;
	private String fullName;
	private String email;
	private String gender;
	private Long phoNum;
	private LocalDate dob;
	private String ssn;

	private String city;
	private String houseNum;
	private String state;

	private Integer createdBy;

	@CreationTimestamp
	private LocalDate createDate;

	@ManyToOne
	@JoinColumn(name="user_Id")
	@JsonBackReference
	private UserEntity usercId;

	@OneToOne(mappedBy ="cpNum",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonBackReference
	private PlanSelection pSelects;

	@OneToOne(mappedBy = "ceNum",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonBackReference
	private EducationDetails eDetails;

	@OneToOne(mappedBy = "ciNum",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonBackReference
	private IncomeDetails iDetails;

	@OneToMany
	@JsonBackReference
	private List<KidsDetails> kDetails;

	@OneToOne(mappedBy = "cedNum", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private EgibilityDetermination eliDetermination;

}
