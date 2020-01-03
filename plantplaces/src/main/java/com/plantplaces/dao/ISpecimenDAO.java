package com.plantplaces.dao;

import org.springframework.stereotype.Component;

import com.plantplaces.dto.SpecimenDTO;

public interface ISpecimenDAO {
	boolean save(SpecimenDTO specimenDTO) throws Exception;
}
