package org.cedam.application.randonnees.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class DayDto {

	private long id;

	private String number;

	private TrekDto trek;

}
