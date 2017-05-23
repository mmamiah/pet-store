package com.mms.rbc.dao;

import java.util.Collection;
import com.mms.rbc.model.user.StoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserRepository
 */
@Transactional
public interface StoreUserDao extends JpaRepository<StoreUser, Long> {
	
	public Collection<StoreUser> findByUserName(String userName);
	
	public Collection<StoreUser> findByFirstName(String firstName);

	public Collection<StoreUser> findByLastName(String lastName);
	
}
