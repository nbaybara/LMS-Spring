package com.nur.librarymanagement.service;

import com.nur.librarymanagement.dto.AuthorDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    AuthorDto save(AuthorDto author);

    AuthorDto getById(Long id);

    TPage<AuthorDto> getAllPageable(Pageable pageable);

    Boolean delete(AuthorDto author);

    AuthorDto update(Long id, AuthorDto project);

}
