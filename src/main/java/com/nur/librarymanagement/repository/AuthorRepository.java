package com.nur.librarymanagement.repository;

import com.nur.librarymanagement.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
