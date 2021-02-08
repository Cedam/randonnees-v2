package org.cedam.application.randonnees.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DAY")
public class Day extends SuperEntity {

	@Column(name = "NUMBER", nullable = false, unique = false)
	private String number;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "TREK_ID")
	private Trek trek;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Trek getTrek() {
		return trek;
	}

	public void setTrek(Trek trek) {
		this.trek = trek;
	}

}