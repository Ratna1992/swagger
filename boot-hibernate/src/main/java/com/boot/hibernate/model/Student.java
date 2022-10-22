package com.boot.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm/dd/yyyy")
	private Date dob;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_std_addr_id")
	@JsonIgnore
	private Address address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_std_subj_id", referencedColumnName = "id")
	@JsonIgnore
	private List<Subject> subject;

}
