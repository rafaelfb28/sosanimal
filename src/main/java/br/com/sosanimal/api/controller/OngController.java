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

import br.com.sosanimal.api.model.OngModel;
import br.com.sosanimal.api.ongmapper.OngMapper;
import br.com.sosanimal.api.repository.OngRepository;
import br.com.sosanimal.api.vo.OngVO;

@RestController
@RequestMapping("ongs")
public class OngController {

	@Autowired
	private OngRepository ongRepository;

	@Autowired
	private OngMapper ongMapper;

	@PostMapping
	public ResponseEntity<OngModel> store(@RequestBody OngVO ongVO) {

		return ResponseEntity.status(HttpStatus.CREATED).body(ongRepository.save(ongMapper.toOng(ongVO)));

	}

	@GetMapping
	public ResponseEntity<List<OngModel>> index() {

		return ResponseEntity.status(HttpStatus.OK).body(ongRepository.findAll());

	}

	@GetMapping("{id}")
	public ResponseEntity<OngModel> show(@PathVariable String id) {

		final Optional<OngModel> ong = ongRepository.findById(UUID.fromString(id));

		if (ong.isPresent()) {

			return ResponseEntity.ok(ong.get());

		} else {

			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping()
	public ResponseEntity<OngModel> update(@RequestBody OngModel ongModel) {
		
		return ResponseEntity.status(HttpStatus.OK).body(ongRepository.save(ongModel));

	}

	@DeleteMapping()
	public void destroy(@RequestBody OngModel ongModel) {

		ongRepository.delete(ongModel);

	}

}
