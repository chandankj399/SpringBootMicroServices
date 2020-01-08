package com.plantplaces.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.plantplaces.dto.PhotoDTO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

public interface ISpecimenService {

	SpecimenDTO fetchById(int id);

	boolean save(SpecimenDTO specimenDTO) throws Exception;
	
	List<PlantDTO> fetchPlants(String string) throws Exception;

	Iterable<SpecimenDTO> fetchAllSpecimens() throws Exception;

	void saveImage(MultipartFile imageFile, PhotoDTO photoDTO) throws Exception;

}