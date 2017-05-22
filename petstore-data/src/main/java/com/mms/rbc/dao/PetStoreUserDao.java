package com.mms.rbc.dao;

import java.util.Collection;
import com.mms.rbc.model.user.PetStoreUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface PetStoreUserDao extends JpaRepository<PetStoreUser, Long> {
	
	public Collection<PetStoreUser> findByUserName(String userName);
	
}
