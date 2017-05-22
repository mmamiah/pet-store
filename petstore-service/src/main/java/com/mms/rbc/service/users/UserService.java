package com.mms.rbc.service.users;

import java.util.Collection;
import com.mms.rbc.model.user.PetStoreUser;

/**
 * UserService
 */
public interface UserService {

	public Collection<PetStoreUser> findByUserName(String userName);
	
}
