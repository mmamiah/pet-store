package com.mms.rbc.service.impl;

import java.util.Collection;
import com.mms.rbc.dao.UserDao;
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
	private UserDao userDao;

	public UserServiceImpl() {
		
	}

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public StoreUser findUser(String userName, String password) {
		StoreUser user = userDao.findUser(userName, password);
		if(user==null){
			user = new StoreUser();
		}
		return user;
	}

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
