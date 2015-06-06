/**
 * 
 */
package com.thbaymet.irfan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbaymet.irfan.dao.BookDao;
import com.thbaymet.irfan.domain.Book;
import com.thbaymet.irfan.service.BookService;

/**
 * @author bayramov.m
 *
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	public void persist(Book entity) {
		bookDao.openCurrentSessionwithTransaction();
		bookDao.persist(entity);
		bookDao.closeCurrentSessionwithTransaction();
	}

	public void update(Book entity) {
		bookDao.openCurrentSessionwithTransaction();
		bookDao.update(entity);
		bookDao.closeCurrentSessionwithTransaction();
	}

	public Book findById(Long id) {
		bookDao.openCurrentSession();
		Book book = bookDao.findById(id);
		bookDao.closeCurrentSession();
		return book;
	}

	public void delete(Long id) {
		bookDao.openCurrentSessionwithTransaction();
		Book book = bookDao.findById(id);
		bookDao.delete(book);
		bookDao.closeCurrentSessionwithTransaction();
	}

	public List<Book> findAll() {
		bookDao.openCurrentSession();
		List<Book> books = bookDao.findAll();
		bookDao.closeCurrentSession();
		return books;
	}

	public void deleteAll() {
		bookDao.openCurrentSessionwithTransaction();
		bookDao.deleteAll();
		bookDao.closeCurrentSessionwithTransaction();
	}

	/**
	 * @return the bookDao
	 */
	public BookDao getBookDao() {
		return bookDao;
	}

	/**
	 * @param bookDao the bookDao to set
	 */
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
