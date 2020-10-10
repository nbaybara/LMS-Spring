package com.nur.librarymanagement.service;

import com.nur.librarymanagement.dto.BookDto;
import com.nur.librarymanagement.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    public List<Book> findAllBooks();
    Book save(Book book);

    BookDto getById(Long id);

    Page<Book> getAllPageable(Pageable pageable);

    Boolean delete(BookDto book);

    BookDto update(Long id, BookDto book);
}
