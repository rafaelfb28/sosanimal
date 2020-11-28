package br.com.sosanimal.api.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ongs")
public class OngModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	
	@Column(nullable = false, length = 45)
	private String name;
	
	@Column(nullable = false, length = 45, unique = true)
	private String email;
	
	@Column(nullable = false, length = 45)
	private String whatsapp;
	
	@Column(nullable = false, length = 45)
	private String city;
	
	@Column(nullable = false, length = 45)
	private String uf;
	
	@Column(nullable = false, length = 45, unique = true)
	private String cnpj;
	
	
	@OneToMany(mappedBy = "ongModel")
	private List<IncidentesModel> incidentesModels;
}
