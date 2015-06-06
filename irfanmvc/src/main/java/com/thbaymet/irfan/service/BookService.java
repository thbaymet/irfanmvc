/**
 * 
 */
package com.thbaymet.irfan.service;

import java.util.List;

import com.thbaymet.irfan.domain.Book;

/**
 * @author bayramov.m
 *
 */
public interface BookService {

	public void persist(Book entity);

	public void update(Book entity);

	public Book findById(Long id);

	public void delete(Long id);

	public List<Book> findAll();

	public void deleteAll();
}
