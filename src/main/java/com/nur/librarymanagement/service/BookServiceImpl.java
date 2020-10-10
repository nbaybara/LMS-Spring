package com.nur.librarymanagement.service;

import com.nur.librarymanagement.dto.AuthorDto;
import com.nur.librarymanagement.dto.BookDto;
import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Book;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.repository.BookRepository;
import com.nur.librarymanagement.repository.PublisherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public BookDto getById(Long id) {
        return null;
    }

    @Override
    public Page<Book> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(BookDto book) {
        return null;
    }

    @Override
    public BookDto update(Long id, BookDto book) {
        return null;
    }

    public List<BookDto> getAll() {
        List<Book> data = bookRepository.findAll();
        return Arrays.asList(modelMapper.map(data, BookDto[].class));
    }
}
