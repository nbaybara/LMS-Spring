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

    Book  getById(Long id);

    public List<Book> searchBooks(String keyword);

    Page<Book> getAllPageable(Pageable pageable);

    Boolean delete(Long id );

    Book update(Long id, Book book);
}
