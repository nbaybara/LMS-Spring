package com.nur.librarymanagement.service.implementation;

import com.nur.librarymanagement.dto.AuthorDto;
import com.nur.librarymanagement.dto.BookDto;
import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Book;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.repository.BookRepository;
import com.nur.librarymanagement.repository.PublisherRepository;
import com.nur.librarymanagement.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;

    public BookServiceImpl(ModelMapper modelMapper, BookRepository bookRepository) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.getOne(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Book> searchBooks(String keyword) {
        if (keyword != null) {
            return bookRepository.search(keyword);
        }
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        bookRepository.deleteById(id);
        return null;
    }

    @Override
    public Book update(Long id, Book book) {
        Book bookDb = bookRepository.getOne(id);
        if(bookDb==null){
            throw  new IllegalArgumentException("Author doesnt exit");
        }
        bookDb.setName(book.getName());
        bookDb.setIsbn(book.getIsbn());
        bookDb.setDescription(book.getDescription());
        bookDb.setSub_name(book.getSerial_name());
        bookDb.setSerial_name(book.getSerial_name());
        return bookRepository.save(bookDb);
    }

    public List<Book> getAll() {
        List<Book> data = bookRepository.findAll();
        return Arrays.asList(modelMapper.map(data, Book[].class));
    }
}
