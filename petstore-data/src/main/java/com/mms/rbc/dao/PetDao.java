package com.mms.rbc.dao;

import javax.transaction.Transactional;
import java.util.Collection;
import com.mms.rbc.model.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * StorePetDao
 */
@Transactional
@Repository
public interface PetDao extends JpaRepository<Pet, Long> {

	public Collection<Pet> findByName(String name);
	
}
