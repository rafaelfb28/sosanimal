package br.com.sosanimal.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sosanimal.api.model.IncidentesModel;
import br.com.sosanimal.api.ongmapper.IncidentesMapper;
import br.com.sosanimal.api.repository.IncidentesRepository;
import br.com.sosanimal.api.vo.IncidentesVO;

@RestController
@RequestMapping("incidentes")
public class IncidentesController {

	@Autowired
	private IncidentesRepository incidentesRepository;

	@Autowired
	private IncidentesMapper incidentesMapper;

	@PostMapping
	public ResponseEntity<IncidentesModel> store(@RequestBody IncidentesVO incidentesVO) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(incidentesRepository.save(incidentesMapper.toIncidentes(incidentesVO)));

	}

	@GetMapping
	public ResponseEntity<List<IncidentesModel>> index() {

		return ResponseEntity.status(HttpStatus.OK).body(incidentesRepository.findAll());

	}

	@GetMapping("{id}")
	public ResponseEntity<IncidentesModel> show(@PathVariable String id) {

		final Optional<IncidentesModel> incidente = incidentesRepository.findById(UUID.fromString(id));

		if (incidente.isPresent()) {

			return ResponseEntity.ok(incidente.get());

		} else {

			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("{id}")
	public ResponseEntity<IncidentesModel> update(@PathVariable final String id,
			@RequestBody IncidentesModel incidentesModel) {

		final Optional<IncidentesModel> incidente = incidentesRepository.findById(UUID.fromString(id));

		if (incidente.isPresent()) {

			return ResponseEntity.status(HttpStatus.OK).body(incidentesRepository.save(incidentesModel));

		} else {

			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> destroy(@PathVariable final String id) {

		final Optional<IncidentesModel> incidente = incidentesRepository.findById(UUID.fromString(id));

		if (incidente.isPresent()) {

			incidentesRepository.deleteById(UUID.fromString(id));
			return ResponseEntity.noContent().build();

		} else {

			return ResponseEntity.notFound().build();
		}

	}

}
