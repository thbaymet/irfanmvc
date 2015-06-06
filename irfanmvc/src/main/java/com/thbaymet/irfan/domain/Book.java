/**
 * 
 */
package com.thbaymet.irfan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author bayramov.m
 *
 */
@Entity
@Table(name = "book")
public class Book extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "title")
	private String title;
	
	@Column(name= "author")
	String author;
	
	public Book() {
	}

	public Book(Long id, String title, String author) {
		this.setId(id);
		this.setTitle(title);
		this.setAuthor(author);
	}
	
	public Book(String title, String author) {
		this.setTitle(title);
		this.setAuthor(author);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book: " + this.getId() + ", " + this.getTitle() + ", " + this.getAuthor();
	}
}
