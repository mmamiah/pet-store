package com.mms.rbc.dao;

import java.util.Collection;
import com.mms.rbc.model.user.StoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserRepository
 */
@Transactional
@Repository
public interface UserDao extends JpaRepository<StoreUser, Long> {

	@Query("select user from StoreUser user where user.userName = ?1 and user.password = ?2")
	public StoreUser findUser(String userName, String password);
	
	public Collection<StoreUser> findByUserName(String userName);
	
	public Collection<StoreUser> findByFirstName(String firstName);

	public Collection<StoreUser> findByLastName(String lastName);
	
}
