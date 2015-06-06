package com.thbaymet.irfan;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thbaymet.irfan.domain.Book;
import com.thbaymet.irfan.service.BookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BookService bookService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		logger.debug("debug logger message home method");
		
		
		Book book = populateBook();
		bookService.persist(book);
		logger.info("book added through book service");
		
		Book booka = bookService.findById((long) 2);
		if (booka != null) {
			bookService.delete(booka.getId());
		}
		
		model.addAttribute("book", book);
		
		return "home";
	}
	
	
	public Book populateBook() {
		Book book = new Book();
		book.setAuthor("BAYRAMOV Matin");
		book.setTitle("Name of Jonny");
		return book;
	}
	
}
