package org.cedam.application.randonnees.dto;

public class DayDto {

	private long id;

	private String number;

	private TrekDto trek;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public TrekDto getTrek() {
		return trek;
	}

	public void setTrek(TrekDto trekDto) {
		this.trek = trekDto;
	}

}
