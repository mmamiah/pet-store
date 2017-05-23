package com.mms.rbc.controllers;

import java.util.Collection;

/**
 * StoreController
 */
public interface StoreController<T> {
	
	public void add(T item);
	
	public T findById(long id);
	
	public Collection<T> findAll();
	
	public void delete(long id);
	
}
