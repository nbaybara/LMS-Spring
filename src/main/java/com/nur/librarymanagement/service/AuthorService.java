package com.nur.librarymanagement.service;
import com.nur.librarymanagement.entity.Author;


public interface AuthorService {
    public void save(Author author);

    Author getById(Long id);

    Boolean delete(Author author);

    Author update(Long id, Author project);

}
