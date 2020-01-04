package com.plantplaces;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;
import com.plantplaces.service.ISpecimenService;

@Controller
public class PlantPlacesController {
	
	@Autowired
	private ISpecimenService specimenService;
	
	@RequestMapping(value="/savespecimen")
	public String saveSpecimen(SpecimenDTO specimenDTO) {
		specimenDTO.setPlantId(10);
		
		return "start";
	}
	
//	@RequestMapping(value="/start", method=RequestMethod.GET)
//	@ResponseBody
//	public SpecimenDTO readJSON(Model model) {
//		SpecimenDTO specimenDTO = specimenServiceStub.fetchById(43);
//		model.addAttribute("specimenDTO", specimenDTO);
//		return specimenDTO;
//	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET, params= {"loyalty=blue"})
	public String readBlue() {
		return "start";
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET, params= {"loyalty=silver"})
	public String readSilver() {
		return "start";
	}
	
	
	@RequestMapping(value="/addspecimen", method=RequestMethod.GET)
	public String addSpecimen(Model model, @RequestParam(value="latitude", required = false, defaultValue = "0.0") String latitude) {
		SpecimenDTO specimenDTO = specimenService.fetchById(43);
		specimenDTO.setLatitude(latitude);
		model.addAttribute("specimenDTO", specimenDTO);
		return "start";
	}
	
	
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read(Model model) {
		model.addAttribute("specimenDTO", new SpecimenDTO());
		return "start";
	}
	
	
	@PostMapping("/start")
	public String create() {
		return "start";
	}
	
	
	@RequestMapping("/")
	public String index() {
		return "start";
	}
	
	@RequestMapping("/searchPlants")
	public String searchPlants(@RequestParam(value="searchTerm", required = false, defaultValue = "") String searchTerm) {
		List<PlantDTO> fetchPlants = specimenService.fetchPlants(searchTerm);
		System.out.println(fetchPlants);
		return "start";
	}
	
	@RequestMapping("/searchPlantsAll")
	public String searchPlantsAll(@RequestParam Map<String, String> requestParams) {
		requestParams.size();
		return "start";
	}
	
	
	@RequestMapping("/sustainability")
	public String sustainabilty() {
		return "sustainability";
	}

}
