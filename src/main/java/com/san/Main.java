package com.san;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.san.domain.Book;
import com.san.repo.BookRepository;
import com.san.service.BookService;

public class Main {

	static BookService bookService;
	static BookRepository productRepository;

	public static void main(ApplicationContext appContext) {
		bookService = appContext.getBean(BookService.class);
		productRepository = appContext.getBean(BookRepository.class);
		System.out.println("Goint to insert 1000 books");
		bookService.insertThousandsBooks();

		System.out.println("Searching first book published in 2011 ");
		List<Book> books = productRepository.findByPublishYear(2011);
		if (books != null && books.size() > 0) {
			System.out.println("First book published in 2011 is : " + books.get(0));
		}
	}
}
