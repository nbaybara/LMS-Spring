package com.nur.librarymanagement;

import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Book;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.service.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return new ModelMapper();
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return (args) -> {

			Book book = new Book("Test book", "Test subname", "Test serial name", "Test isbn", "Test desc");
			Author author = new Author("Test author name", "Test description");
			Publisher publisher = new Publisher("Test publisher name", "Test publisher deneme");

			book.addAuthors(author);
			book.addPublishers(publisher);

			bookService.save(book);

			Book book1 = new Book("Test isbn1", "Test name1", "Test serial name1", "Test description1", "desc book");
			Author author1 = new Author("Test author name1", "Test description1");
			Publisher publisher1 = new Publisher("Test publisher name1", "deneme");

			book1.addAuthors(author1);

			book1.addPublishers(publisher1);

			bookService.save(book1);

			Book book2 = new Book("Test isbn2", "Test name2", "Test serial name2", "547457422", "desc");
			Author author2 = new Author("Test author name2", "Test description2");
			Publisher publisher2 = new Publisher("Test publisher name2", "kkkk");

			book2.addAuthors(author2);
			book2.addPublishers(publisher2);

			bookService.save(book2);

		};

	}
}
