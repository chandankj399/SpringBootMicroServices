package com.plantplaces.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

@Component
public class SpecimenServiceStub implements ISpecimenService {
	
	@Autowired
	private ISpecimenDAO specimenDAO;
	
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
	public boolean save(SpecimenDTO specimenDTO) throws Exception{
		boolean result = specimenDAO.save(specimenDTO);
		return result;
	}

	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) {
		// TODO Auto-generated method stub
		
		List<PlantDTO> matchingPlants = new ArrayList<PlantDTO>();
		if (searchTerm.contains("edbud") || searchTerm.contains("Cersis")) {
			PlantDTO plant = new PlantDTO();
			plant.setGenus("Cercis");
			plant.setSpecies("canadensis");
			plant.setCommon("Eastern Redbud");
			matchingPlants.add(plant);
		}
		return matchingPlants;
	}

	@Override
	public Iterable<SpecimenDTO> fetchAllSpecimens() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
