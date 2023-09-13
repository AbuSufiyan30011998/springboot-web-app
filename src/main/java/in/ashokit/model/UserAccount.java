package in.ashokit.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_account")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String fullName;
	private String email;
	private Long phnNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	private String gender;
	private Long ssn;
	private String activeSw;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createDate;

	@CreationTimestamp
	@Column(insertable = false)
	private LocalDate updateDate;

}
