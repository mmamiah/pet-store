package com.mms.rbc.service;

import java.util.Collection;

/**
 * StoreService
 */
public interface StoreService<T> {

	public T save(T item);

	public T findById(long id);
	
	public Collection<T> findByName(String name);

	public Collection<T> findAll();

	public void delete(long id);
	
}
