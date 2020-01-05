package com.plantplaces.dao;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.PlantList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class PlantsDAO implements IPlantDAO {
	
	@Autowired
	NetworkDAO networkDAO;


	public List<PlantDTO> fetchManual(String searchFilter) throws Exception {
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

	@Override
	public List<PlantDTO> fetch(String searchFilter) throws Exception {
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://plantplaces.com")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		GetPlants getPlants = retrofit.create(GetPlants.class);
		
		Call<PlantList> allPlants = getPlants.getAllPlants(searchFilter);
		Response<PlantList> execute = allPlants.execute();
		PlantList plantList = execute.body();
		
		// TODO Auto-generated method stub
		return plantList.getPlants();
	}
}
