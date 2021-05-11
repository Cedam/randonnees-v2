package org.cedam.application.randonnees.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class TrekDto {

	private long id;

	private String name;

	private int year;

	private String location;

	private List<DayDto> days = new ArrayList<>();

}
