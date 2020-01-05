package com.plantplaces.dao;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plantplaces.dto.PlantDTO;

@Component
public class PlantsDAO implements IPlantDAO {
	
	@Autowired
	NetworkDAO networkDAO;

	@Override
	public List<PlantDTO> fetch(String searchFilter) throws Exception {
		List<PlantDTO> allPlants = new ArrayList<PlantDTO>();
		
		String rawJson = networkDAO.request("https://www.plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=Oak");
		
		JSONObject root = new JSONObject(rawJson);
		
		JSONArray plants = root.getJSONArray("plants");
		
		for(int i =0; i < plants.length(); i++) {
			// the JSON data
			JSONObject jsonPlant = plants.getJSONObject(i);
			
			// Plant object that we will populate from JSON
			PlantDTO plant = new PlantDTO();
			int guid = jsonPlant.getInt("id");
			String genus = jsonPlant.getString("genus");
			String species = jsonPlant.getString("species");
			String cultivar = jsonPlant.getString("cultivar");
			String common = jsonPlant.getString("common");
			
			plant.setGuid(guid);
			plant.setGenus(genus);
			plant.setCultivar(cultivar);
			plant.setCommon(common);
			plant.setSpecies(species);
			
			allPlants.add(plant);
		}
		
		return allPlants;
	}
}
