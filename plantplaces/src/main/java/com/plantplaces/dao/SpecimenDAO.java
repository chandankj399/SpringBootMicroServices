package com.plantplaces.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plantplaces.dto.SpecimenDTO;

@Component
public class SpecimenDAO implements ISpecimenDAO {
	
	@Autowired
	SpecimenRepository specimenRepository;
	
	@Override
	public boolean save(SpecimenDTO specimenDTO) throws Exception {
		// TODO Auto-generated method stub
		specimenRepository.save(specimenDTO);
		return false;
	}
	
	@Override
	public Iterable<SpecimenDTO> fethAll() throws Exception {
		return specimenRepository.findAll();
	}
	
	@Override
	public List<SpecimenDTO> fetchSpecimensByPlantId(int plantId){
		return specimenRepository.findByPlantId(plantId);
	}

}
