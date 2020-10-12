package com.nur.librarymanagement.service;

import com.nur.librarymanagement.dto.BookDto;
import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.util.TPage;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PublisherService {
    public List<Publisher> getAll();

   public PublisherDto save(PublisherDto book);

    Publisher getById(Long id);

    Boolean delete(Publisher Publisher);

    Publisher update(Long id, Publisher publisher);
}

