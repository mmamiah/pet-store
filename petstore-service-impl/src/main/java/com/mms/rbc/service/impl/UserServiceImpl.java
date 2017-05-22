package com.mms.rbc.service.impl;

import java.util.Collection;
import com.mms.rbc.dao.PetStoreUserDao;
import com.mms.rbc.model.user.PetStoreUser;
import com.mms.rbc.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PetStoreUserDao petStoreUserDao;

	@Override
	public Collection<PetStoreUser> findByUserName(String userName) {
		return petStoreUserDao.findByUserName(userName);
	}
	
}
