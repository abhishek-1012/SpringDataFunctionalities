package com.springdata.springDataFunctionalities.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl_student",
       uniqueConstraints=@UniqueConstraint(
        		name="emailid_unique",
        		columnNames="email_address"
        		)
)                                    // By this, the name of the table in Db becomes "tbl_student"
public class Student {

	@Id
	@SequenceGenerator(
			name="student_sequence",
			sequenceName="student_sequence",
			allocationSize=1
			)
	@GeneratedValue(
			
			strategy=GenerationType.SEQUENCE,
			generator= "student_sequence"
			)
	private Long studentID;
	private String firstName;
	private String lastName;
	
	@Column(name="Email_Address",
			nullable=false
			) //it helps us define the name of the column in database
	private String emailID;
	
	@Embedded
	private Guardian guardian;
	
}
