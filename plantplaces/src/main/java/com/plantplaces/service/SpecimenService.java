package com.plantplaces.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.plantplaces.dao.IPhotoDAO;
import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PhotoDTO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

@Component
public class SpecimenService implements ISpecimenService {
	
	@Autowired
	IPlantDAO plantDAO;

	@Autowired
	ISpecimenDAO specimenDAO;
	
	@Autowired
	IPhotoDAO photoDAO;
	
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
	@Cacheable("fetchPlants")
	public List<PlantDTO> fetchPlants(String searchTerm) throws Exception{
		
		return plantDAO.fetchManual(searchTerm);
	}
	
	
	@Override
	public Iterable<SpecimenDTO> fetchAllSpecimens() throws Exception {
		return specimenDAO.fethAll();
	}

	@Override
	public void saveImage(MultipartFile imageFile, PhotoDTO photoDTO) throws Exception {
		// TODO Auto-generated method stub
		photoDAO.save(photoDTO);
		photoDAO.savePhotoImage(imageFile);
	}

}
