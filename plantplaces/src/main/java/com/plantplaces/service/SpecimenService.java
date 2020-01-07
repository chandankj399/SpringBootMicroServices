package com.plantplaces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

@Component
public class SpecimenService implements ISpecimenService {
	
	@Autowired
	IPlantDAO plantDAO;

	@Override
	public SpecimenDTO fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(SpecimenDTO specimenDTO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) throws Exception{
		
		return plantDAO.fetchManual(searchTerm);
	}

}
