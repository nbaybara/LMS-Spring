package com.nur.librarymanagement.service.implementation;

import com.nur.librarymanagement.dto.BookDto;
import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.repository.PublisherRepository;
import com.nur.librarymanagement.service.PublisherService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

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
    public Publisher getById(Long id) {
        return publisherRepository.getOne(id);
    }


    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }
    @Override
    public Boolean delete(Publisher publisher) {
        return null;
    }

    public Boolean delete(Long id) {
        publisherRepository.deleteById(id);
        return null;
    }

    @Override
    public Publisher update(Long id, Publisher publisher) {
        Publisher publisherDb = publisherRepository.getOne(id);
        if (publisherDb == null) {
            throw new IllegalArgumentException("Publisher doesnt exit");
        }
        publisherDb.setName(publisher.getName());
        publisherDb.setDescription(publisher.getDescription());
        return publisherRepository.save(publisherDb);

    }
}
