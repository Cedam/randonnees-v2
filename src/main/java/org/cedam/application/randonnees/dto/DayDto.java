package org.cedam.application.randonnees.dto;

public class DayDto {

	private long id;

	private String number;

	private TrekDto trekDto;

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
		return trekDto;
	}

	public void setTrek(TrekDto trekDto) {
		this.trekDto = trekDto;
	}

}
