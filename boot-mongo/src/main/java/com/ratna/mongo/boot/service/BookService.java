package com.ratna.mongo.boot.service;

import java.util.List;

import com.ratna.mongo.boot.model.Book;

public interface BookService {

	List<Book> loadData();

	List<Book> getAllBooks();

	Book getBookById(Integer id);
	
	List<Book> getBooksByPagesLessThan(Integer pages);
	
	List<Book> getBooksByPagesGreaterThan(Integer pages);
	
	List<Book> getBooksByPages(Integer pages);
	
	List<Book> getBooksByAuthorAndCost(String author, Double cost);
	
	List<Book> getBooksByAuthorOrName(String author, String name);
	
	Integer getBooksCountByAuthor(String author);
	
	List<Book> getBooksByAuthorSortByNameASC(String author);
	
	List<Book> getBooksByAuthorSortByNameDESC(String author);
	
	List<Book> getBookNameAndAuthorByPages(Integer pages);
	
	List<Book> getBooksByAuthorRegEx(String author);
	
	List<Book> getBooksByCostBetween(Double costGt, Double costLt);

}
