package br.com.sosanimal.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sosanimal.api.model.IncidentesModel;

@Repository
public interface IncidentesRepository extends JpaRepository<IncidentesModel, UUID>{

}
