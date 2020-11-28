package br.com.sosanimal.api.ongmapper;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sosanimal.api.model.IncidentesModel;
import br.com.sosanimal.api.repository.OngRepository;
import br.com.sosanimal.api.vo.IncidentesVO;

@Component
public class IncidentesMapper {

	@Autowired
	private OngRepository ongRepository;

	public IncidentesModel toIncidentes(final IncidentesVO incidentesVO) {

		IncidentesModel incidentesModel = new IncidentesModel();

		incidentesModel.setTitle(incidentesVO.getTitle());
		incidentesModel.setDescription(incidentesVO.getDescription());
		incidentesModel.setValue(incidentesVO.getValue());
		incidentesModel.setStatus(incidentesVO.getStatus());
		incidentesModel.setOngModel(ongRepository.findById(UUID.fromString(incidentesVO.getIdOng())).orElse(null));

		return incidentesModel;

	}

}
