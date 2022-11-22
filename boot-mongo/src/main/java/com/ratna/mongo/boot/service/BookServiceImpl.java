package com.ratna.mongo.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratna.mongo.boot.model.Book;
import com.ratna.mongo.boot.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repo;

	@Override
	public List<Book> loadData() {
		return repo.saveAll(List.of(new Book(500, "Core Java", 200, "Kathy Sierra", 1065.5),
				new Book(501, "JSP & Servlets", 350, "Kathy Sierra", 1749.0),
				new Book(502, "Spring in Action", 480, "Craig Walls", 940.75),
				new Book(503, "Pro Angular", 260, "Freeman", 1949.25),
				new Book(504, "HTML CSS", 100, "Thomas Powell", 2317.09),
				new Book(505, "Hibernate in Action", 180, "Gavin King", 889.25),
				new Book(506, "Practical MongoDB", 180, "Shakuntala Gupta", 785.0),
				new Book(507, "Pro Spring Boot", 850, "Felipe Gutierrez", 2167.99),
				new Book(508, "Beginning jQuery", 180, "Franklin", 1500.00),
				new Book(509, "Java Design Patterns", 114, "Devendra Singh", 919.99)));
	}

	@Override
	public List<Book> getAllBooks() {
		return repo.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		return repo.getBookById(id).get();
	}

	@Override
	public List<Book> getBooksByPagesLessThan(Integer pages) {
		return repo.getBooksByPagesLessThan(pages);
	}

	@Override
	public List<Book> getBooksByPagesGreaterThan(Integer pages) {
		return repo.getBooksByPagesGreaterThan(pages);
	}

	@Override
	public List<Book> getBooksByPages(Integer pages) {
		return repo.getBooksByPages(pages);
	}

	@Override
	public List<Book> getBooksByAuthorAndCost(String author, Double cost) {
		return repo.getBooksByAuthorAndCost(author, cost);
	}

	@Override
	public List<Book> getBooksByAuthorOrName(String author, String name) {
		return repo.getBooksByAuthorOrName(author, name);
	}

	@Override
	public Integer getBooksCountByAuthor(String author) {
		return repo.getBooksCountByAuthor(author);
	}

	@Override
	public List<Book> getBooksByAuthorSortByNameASC(String author) {
		return repo.getBooksByAuthorSortByNameASC(author);
	}

	@Override
	public List<Book> getBooksByAuthorSortByNameDESC(String author) {
		return repo.getBooksByAuthorSortByNameDESC(author);
	}

	@Override
	public List<Book> getBookNameAndAuthorByPages(Integer pages) {
		return repo.getBookNameAndAuthorByPages(pages);
	}

	@Override
	public List<Book> getBooksByAuthorRegEx(String author) {
		return repo.getBooksByAuthorRegEx(author);
	}

}
