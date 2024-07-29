package com.brytcode.springjdbc;

import com.brytcode.springjdbc.book.Book;
import com.brytcode.springjdbc.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(SpringjdbcApplication.class, args);
		BookRepository br = app.getBean("bookRepository", BookRepository.class);
		List<Book> books = br.getBooks();
		System.out.println(books);
		/*br.updateBook(101, BigDecimal.valueOf(14));*/
		br.updateBookByParams(102,BigDecimal.valueOf(16));
	}

}
