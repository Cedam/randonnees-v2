package org.cedam.application.randonnees.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "DAY")
public class Day extends SuperEntity {

	@Column(name = "NUMBER", nullable = false, unique = false)
	private String number;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "TREK_ID")
	private Trek trek;

}