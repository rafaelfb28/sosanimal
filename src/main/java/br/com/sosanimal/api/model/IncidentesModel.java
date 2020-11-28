package br.com.sosanimal.api.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "incidentes")
public class IncidentesModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	
	@Column(nullable = false, length = 45)
	private String title;
	
	@Column(nullable = false, length = 45)
	private String description;
	
	@Column(nullable = false, length = 45)
	private String value;
	
	@Column(nullable = false, length = 45)
	private String status;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "fk_ong", referencedColumnName = "id")
	private OngModel ongModel;
	
	
}
