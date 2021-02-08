package org.cedam.application.randonnees.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TREK")
public class Trek extends SuperEntity {

	@Column(name = "NAME", nullable = false, unique = false)
	private String name;

	@Column(name = "YEAR", nullable = false, unique = false)
	private int year;

	@Column(name = "LOCATION", nullable = false, unique = false)
	private String location;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trek")
	private List<Day> days = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

}