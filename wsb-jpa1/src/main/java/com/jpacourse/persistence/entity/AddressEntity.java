package com.jpacourse.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String street;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String postalCode;

	@ManyToMany(mappedBy = "addresses")
	private Set<PatientEntity> patients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Set<PatientEntity> getPatients() {
		return patients;
	}

	public void setPatients(Set<PatientEntity> patients) {
		this.patients = patients;
	}
}
