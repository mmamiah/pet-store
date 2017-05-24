package com.mms.rbc.service.impl;

import java.util.Collection;
import com.mms.rbc.dao.PetDao;
import com.mms.rbc.model.pet.Pet;
import com.mms.rbc.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PetServiceImpl
 */
@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetDao petDao;

	public PetServiceImpl() {
	}

	public PetServiceImpl(PetDao petDao) {
		this.petDao = petDao;
	}

	@Override
	public Pet save(Pet item) {
		return petDao.save(item);
	}

	@Override
	public Pet findById(long id) {
		return petDao.findOne(id);
	}

	@Override
	public Collection<Pet> findByName(String name) {
		return petDao.findByName(name);
	}

	@Override
	public Collection<Pet> findAll() {
		return petDao.findAll();
	}

	@Override
	public void delete(long id) {
		petDao.delete(id);
	}
	
}
