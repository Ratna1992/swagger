package com.boot.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Address {

	@Id
	@GeneratedValue
	private int address_id;
	private String city;
	private String state;
	private String landmark;
	private String zipCode;
	private String type;
	@OneToOne(mappedBy = "address")
	@JsonIgnore
	private Student student;

}
