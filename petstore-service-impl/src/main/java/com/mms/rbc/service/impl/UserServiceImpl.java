package com.mms.rbc.service.impl;

import java.util.Collection;
import com.mms.rbc.dao.StoreUserDao;
import com.mms.rbc.model.user.StoreUser;
import com.mms.rbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private StoreUserDao userDao;

	@Override
	public Collection<StoreUser> findByName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public StoreUser save(StoreUser item) {
		return  userDao.save(item);
	}

	@Override
	public StoreUser findById(long id) {
		return userDao.findOne(id);
	}

	@Override
	public Collection<StoreUser> findAll() {
		return userDao.findAll();
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
	}
}
