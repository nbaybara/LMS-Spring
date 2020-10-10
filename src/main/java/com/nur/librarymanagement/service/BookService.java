package com.nur.librarymanagement.service;

import com.nur.librarymanagement.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    BookDto save(BookDto book);

    BookDto getById(Long id);


    Page<BookDto> getAllPageable(Pageable pageable);

    Boolean delete(BookDto book);

    BookDto update(Long id, BookDto book);
}
