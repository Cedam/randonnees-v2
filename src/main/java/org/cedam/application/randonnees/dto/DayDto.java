package org.cedam.application.randonnees.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Service
@Getter
@Setter
@ToString
public class DayDto {

	private long id;

	private String number;

	private long idTrek;

	private TrekDto trek;

}
