package com.mms.rbc.controllers;

import java.util.Collection;
import com.mms.rbc.enums.PetGroup;
import com.mms.rbc.enums.PetType;
import com.mms.rbc.enums.PetUsage;
import com.mms.rbc.model.pet.Pet;
import com.mms.rbc.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * PetController
 */
@RestController
public class PetController {
	
	@Autowired
	private PetService petService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/pet")
	public ResponseEntity<?> savePet(ModelMap modelMap) {
		Pet pet = new Pet();
		pet = petService.save(pet);
		return new ResponseEntity<>(pet, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pet/{petId}")
	public Pet findById(@PathVariable("petId") long petId) {
		return petService.findById(petId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pet")
	public Collection<Pet> findAll() {
		return petService.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/pet/{petId}")
	public ResponseEntity<?> delete(@PathVariable("petId") long petId) {
		petService.delete(petId);
		return new ResponseEntity<>(petId, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pet/petusages")
	public PetUsage[] getPetUsages() {
		return PetUsage.values();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pet/petgroups")
	public PetGroup[] getPetGroups() {
		return PetGroup.values();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pet/pettypes")
	public PetType[] getPetTypes() {
		return PetType.values();
	}
	
}
