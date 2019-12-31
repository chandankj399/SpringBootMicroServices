package com.plantplaces.service;

import java.util.List;

import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

public interface ISpecimenService {

	SpecimenDTO fetchById(int id);

	void save(SpecimenDTO specimenDTO);
	
	List<PlantDTO> fetchPlants(String string);

}