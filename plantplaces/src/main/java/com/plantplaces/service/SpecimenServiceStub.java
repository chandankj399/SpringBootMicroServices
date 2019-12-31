package com.plantplaces.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

@Component
public class SpecimenServiceStub implements ISpecimenService {
	
	@Override
	public SpecimenDTO fetchById(int id) {
		SpecimenDTO specimenDTO = new SpecimenDTO();
		specimenDTO.setSpecimenId(43);
		specimenDTO.setLatitude("100");
		specimenDTO.setLongitude("100");
		specimenDTO.setDescription("A Beautiful Eastern Redbud");
		return specimenDTO;
	}
	
	@Override
	public void save(SpecimenDTO specimenDTO) {
		
	}

	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) {
		// TODO Auto-generated method stub
		if (searchTerm.contains("edbud") || searchTerm.contains("Cersis")) {
			PlantDTO plant = new PlantDTO();
			plant.setGenus("Cercis");
			plant.setSpecies("canadensis");
			plant.setCommon("Eastern Redbud");
		}
		return null;
	}

}
