package com.boot.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Subject {

	@Id
	@GeneratedValue
	private int subject_id;
	private String name;
	private String marks;
	private Boolean isFailed;

}
