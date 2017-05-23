package com.mms.rbc.service.users;

import java.util.Collection;
import com.mms.rbc.model.user.StoreUser;

/**
 * UserService
 */
public interface UserService {

	public Collection<StoreUser> findByUserName(String userName);
	
}
