package com.springdata.springDataFunctionalities.Entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
	@AttributeOverride(
			name="Name",
			column= @Column(name="guardian_name")
			),
	@AttributeOverride(
			name="Email",
			column=@Column(name="guardian_email")
			),
	@AttributeOverride(
			name="Mobile",
			column=@Column(name="guardian_mobile")
			)
	
})
public class Guardian {

	private String Name;
	private String Email;
	private String Mobile;
}
