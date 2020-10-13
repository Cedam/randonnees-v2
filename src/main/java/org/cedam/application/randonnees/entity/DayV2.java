package org.cedam.application.randonnees.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DAY")
public class DayV2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "NUMBER", nullable = false, unique = false)
	private String number;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "TREK_ID")
	private TrekV2 trek;

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

	public TrekV2 getTrek() {
		return trek;
	}

	public void setTrek(TrekV2 trek) {
		this.trek = trek;
	}

	
}