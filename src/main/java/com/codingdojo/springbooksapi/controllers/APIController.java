package com.codingdojo.springbooksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.springbooksapi.models.Book;
import com.codingdojo.springbooksapi.services.BookService;

@RestController
@RequestMapping("/api")
public class APIController {
// 		OPTION 1
		@Autowired
		private BookService bookService;
	
	
//		OPTION 2
//		private final BookService bookService;
//	  	
//		public APIController(BookService bookService){
//		  this.bookService = bookService;
//	    }
//	    Read all Route
	    @RequestMapping("/books")
	    public List<Book> getAllBooks() {
	        return bookService.allBooks();
	    }
//	    Create one Route
	    @PostMapping("/books/new")
	    public Book createBook(
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc, 
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages) {
	    	
	        Book book = new Book(title, desc, lang, numOfPages);
	        return bookService.createBook(book);
	    }
//	    Read One route
	    @RequestMapping("/books/{id}")
	    public Book getOneBook(@PathVariable("id") Long id) {
	        Book book = bookService.findBook(id);
	        return book;
	    }
	    
//	    Update One Route
	    @PutMapping("/books/{id}")
	    public Book updateBookById(
	    		@PathVariable("id") Long id,
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc, 
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages
	    		) {
//	    	get target book by id
	    	Book book = bookService.findBook(id);
	    	book.setTitle(title);
	    	book.setDescription(desc);
	    	book.setLanguage(lang);
	    	book.setNumberOfPages(numOfPages);
	    	return bookService.updateBook(book);
	    }
	    
//	    Delete one Route
	    @DeleteMapping("/books/{id}")
	    public void deleteBookById(@PathVariable("id")Long id) {
	    	bookService.deleteBookById(id);
	    	
	    }
	}