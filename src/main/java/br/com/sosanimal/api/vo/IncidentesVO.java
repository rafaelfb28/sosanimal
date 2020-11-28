package br.com.sosanimal.api.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IncidentesVO {

	private String title;

	private String description;

	private String value;

	private String status;	
	
	private String idOng;

}
