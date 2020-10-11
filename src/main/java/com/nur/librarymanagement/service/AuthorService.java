package com.nur.librarymanagement.service;
import com.nur.librarymanagement.dto.AuthorDto;
import com.nur.librarymanagement.entity.Author;


public interface AuthorService {
    AuthorDto save(AuthorDto author);

    Author getById(Long id);

    Boolean delete(Author author);

    Author update(Long id, Author project);

}
