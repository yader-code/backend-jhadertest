package com.jhadertest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="advisor")
public class Advisor extends Entities{
	
	@NotNull
	@Column(length=50)
	private String name;
	
	@NotNull
	@Column(length = 50)
    private String specialty;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
    
}
