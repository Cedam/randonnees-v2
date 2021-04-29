package org.cedam.application.randonnees.dto;

import java.util.ArrayList;
import java.util.List;

public class TrekDto {

	private long id;

	private String name;

	private int year;

	private String location;

	private List<DayDto> daysDto = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public List<DayDto> getDaysDto() {
		return daysDto;
	}

	public void setDaysDto(List<DayDto> daysDto) {
		this.daysDto = daysDto;
	}

}
