/**
 * 
 */
package com.thbaymet.irfan.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author bayramov.m
 *
 */
public interface BookDaoInterface<T, ID extends Serializable> {

	public void persist(T entity);
	
	public void update(T entity);
	
	public T findById(Long id);
	
	public void delete(T entity);
	
	public List<T> findAll();
	
	public void deleteAll();
	
}
