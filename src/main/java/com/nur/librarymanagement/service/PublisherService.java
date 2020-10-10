package com.nur.librarymanagement.service;

import com.nur.librarymanagement.dto.BookDto;
import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PublisherService  {
    public  List<Publisher> getAll();
    PublisherDto save(PublisherDto book);

    PublisherDto getById(Long id);

    TPage<Publisher> getAllPageable(Pageable pageable);

    Boolean delete(PublisherDto publisher);

    PublisherDto update(Long id, PublisherDto publisher);
}

