package org.cedam.application.randonnees.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "TREK")
public class Trek extends SuperEntity {

	@Column(name = "NAME", length = 50, nullable = false, unique = false)
	private String name;

	@Column(name = "YEAR", nullable = false, unique = false)
	private int year;

	@Column(name = "LOCATION", length = 50, nullable = false, unique = false)
	private String location;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trek", fetch = FetchType.EAGER)
	private List<Day> days = new ArrayList<>();

}