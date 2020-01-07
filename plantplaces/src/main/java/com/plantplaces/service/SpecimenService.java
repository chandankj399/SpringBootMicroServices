package com.plantplaces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

@Component
public class SpecimenService implements ISpecimenService {
	
	@Autowired
	IPlantDAO plantDAO;

	@Autowired
	ISpecimenDAO specimenDAO;
	
	@Override
	public SpecimenDTO fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(SpecimenDTO specimenDTO) throws Exception {
		// TODO Auto-generated method stub
		specimenDAO.save(specimenDTO);
		return false;
	}
	
	
	
	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) throws Exception{
		
		return plantDAO.fetchManual(searchTerm);
	}
	
	
	@Override
	public Iterable<SpecimenDTO> fetchAllSpecimens() throws Exception {
		return specimenDAO.fethAll();
	}

}
