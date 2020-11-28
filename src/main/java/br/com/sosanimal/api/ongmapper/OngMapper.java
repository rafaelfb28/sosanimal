package br.com.sosanimal.api.ongmapper;

import org.springframework.stereotype.Component;

import br.com.sosanimal.api.model.OngModel;
import br.com.sosanimal.api.vo.OngVO;

@Component
public class OngMapper {
	
	public OngModel toOng(final OngVO ongVO) {
		
		OngModel ongModel = new OngModel();
		
		ongModel.setName(ongVO.getName());
		ongModel.setEmail(ongVO.getEmail());
		ongModel.setWhatsapp(ongVO.getWhatsapp());
		ongModel.setUf(ongVO.getUf());
		ongModel.setCnpj(ongVO.getCnpj());
		ongModel.setCity(ongVO.getCity());
		
		return ongModel;
		
	}
	

}
