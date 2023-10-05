package com.codingdojo.springbooksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.springbooksapi.models.Book;
import com.codingdojo.springbooksapi.repositories.BookRepository;

@Service
public class BookService {
    // Import the book repository as a dependency
    private final BookRepository bookRepo;

    //Instantiate the class
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }
    
    // find all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    
    // find one book
    public Book findBook(Long id) {
    	Optional<Book>optionalBook = bookRepo.findById(id);
    	if(optionalBook.isPresent() ) {
    		return optionalBook.get();
    	} else {
    		return null;
    	}
    }
    
    // update one book 
    public Book updateBook(Book updatedBook) {
    	return bookRepo.save(updatedBook);
    }
    
    // delete one book
    public void deleteBookById(Long id) {
    	bookRepo.deleteById(id);
    }
}
