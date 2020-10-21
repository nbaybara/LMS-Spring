package com.nur.librarymanagement;

import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Book;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.service.BookService;
import com.nur.librarymanagement.user.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;

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

			Book book = new Book("The new Adam D. Mystery", "National Bestseller", "-", "78569", "National Bestseller");
			Author author = new Author("P.D. James", "Phyllis Dorothy James");
			Publisher publisher = new Publisher("CAN", "can");

			book.addAuthors(author);
			book.addPublishers(publisher);

			bookService.save(book);

			Book book1 = new Book("Yakıcı Sır", "-", "-", "12365", "World Literature");
			Author author1 = new Author("Stefan Zweig", "Austrian writer");
			Publisher publisher1 = new Publisher("Venedik", "Venedik");

			book1.addAuthors(author1);

			book1.addPublishers(publisher1);

			bookService.save(book1);

			Book book2 = new Book("Bir yumak Mutluluk", "New York Times BestSeller", "-", "547457422", "From D. Macomber");
			Author author2 = new Author("Debbie Macomber", "Explore World");
			Publisher publisher2 = new Publisher("MARTI", "Martı");

			book2.addAuthors(author2);
			book2.addPublishers(publisher2);
			bookService.save(book2);

			Book book3 = new Book("Masumiyet Müzesi", "Aşk ve Müze üzerine Yazarın son sözüyle", "-", "978-975-08-2614-6", "Hayatımın en mutlu anıymış, bilmiyordum.");
			Author author3 = new Author("Orhan Pamuk", "Nobel ödüllü yazar");
			Publisher publisher3 = new Publisher("YKY", "YKY");

			book3.addAuthors(author3);
			book3.addPublishers(publisher3);
			bookService.save(book3);



		};

	}
}
