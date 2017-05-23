package com.mms.rbc.dao;

import java.util.Collection;
import com.mms.rbc.model.user.StoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserRepository
 */
@Transactional
public interface PetStoreUserDao extends JpaRepository<StoreUser, Long> {
	
	public Collection<StoreUser> findByUserName(String userName);
	
}
