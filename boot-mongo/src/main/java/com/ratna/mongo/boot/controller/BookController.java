package com.ratna.mongo.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratna.mongo.boot.model.Book;
import com.ratna.mongo.boot.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/loadData")
	public List<Book> loadData() {
		return bookService.loadData();
	}

	@GetMapping()
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		return bookService.getBookById(id);
	}

	@GetMapping("/lt/{pages}")
	public List<Book> getBooksByPagesLessThan(@PathVariable("pages") Integer pages) {
		return bookService.getBooksByPagesLessThan(pages);
	}

	@GetMapping("/gt/{pages}")
	public List<Book> getBooksByPagesGreaterThan(@PathVariable("pages") Integer pages) {
		return bookService.getBooksByPagesGreaterThan(pages);
	}

	@GetMapping("/eq/{pages}")
	public List<Book> getBooksByPages(@PathVariable("pages") Integer pages) {
		return bookService.getBooksByPages(pages);
	}

	@GetMapping("/and/{author}/{cost}")
	public List<Book> getBooksByAuthorAndCost(@PathVariable("author") String author,
			@PathVariable("cost") Double cost) {
		return bookService.getBooksByAuthorAndCost(author, cost);
	}

	@GetMapping("/or/{author}/{name}")
	public List<Book> getBooksByAuthorOrName(@PathVariable("author") String author, @PathVariable("name") String name) {
		return bookService.getBooksByAuthorOrName(author, name);
	}

	@GetMapping("/count/{author}")
	public Integer getBooksCountByAuthor(@PathVariable("author") String author) {
		return bookService.getBooksCountByAuthor(author);
	}

	@GetMapping("/asc/{author}")
	public List<Book> getBooksByAuthorSortByNameASC(@PathVariable("author") String author) {
		return bookService.getBooksByAuthorSortByNameASC(author);
	}

	@GetMapping("/desc/{author}")
	public List<Book> getBooksByAuthorSortByNameDESC(@PathVariable("author") String author) {
		return bookService.getBooksByAuthorSortByNameDESC(author);
	}

	@GetMapping("/projection/{pages}")
	public List<Book> getBookNameAndAuthorByPages(@PathVariable("pages") Integer pages) {
		return bookService.getBookNameAndAuthorByPages(pages);
	}

	@GetMapping("/regex/{author}")
	public List<Book> getBooksByAuthorRegEx(@PathVariable("author") String author) {
		return bookService.getBooksByAuthorRegEx(author);
	}

	@GetMapping("/btw/{costGt}/{costLt}")
	public List<Book> getBooksByCostBetween(@PathVariable("costGt") Double costGt,
			@PathVariable("costLt") Double costLt) {
		return bookService.getBooksByCostBetween(costGt, costLt);
	}
}
