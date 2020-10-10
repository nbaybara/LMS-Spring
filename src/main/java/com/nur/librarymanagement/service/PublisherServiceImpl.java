package com.nur.librarymanagement.service;

import com.nur.librarymanagement.dto.BookDto;
import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.repository.PublisherRepository;
import com.nur.librarymanagement.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.h2.engine.Mode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class PublisherServiceImpl implements PublisherService {

    private final ModelMapper modelMapper;
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(ModelMapper modelMapper, PublisherRepository publisherRepository) {
        this.modelMapper = modelMapper;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public PublisherDto save(PublisherDto publisher) {
        Publisher p = modelMapper.map(publisher, Publisher.class);
        p = publisherRepository.save(p);
        publisher.setId(p.getId());
        return publisher;
    }

    @Override
    public PublisherDto getById(Long id) {
        Publisher p= publisherRepository.getOne(id);
        return modelMapper.map(p,PublisherDto.class);
    }

    @Override
    public TPage<Publisher> getAllPageable(Pageable pageable) {
        return null;
    }

    public Boolean delete(Long id) {
        publisherRepository.deleteById(id);
        return true;
    }

    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Boolean delete(PublisherDto publisher) {
        return null;
    }

    @Override
    public PublisherDto update(Long id, PublisherDto publisher) {
        Publisher publisherDb = publisherRepository.getOne(id);
        if(publisherDb==null){
            throw  new IllegalArgumentException("Publisher doesnt exit");
        }
        publisherDb.setName(publisher.getName());
        publisherDb.setDescription(publisher.getDescription());
        publisherRepository.save(publisherDb);
        return  modelMapper.map(publisherDb,PublisherDto.class);

    }
}
