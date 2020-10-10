package com.nur.librarymanagement.service;

import com.nur.librarymanagement.dto.AuthorDto;
import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.repository.AuthorRepository;
import com.nur.librarymanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDto save(AuthorDto author) {
        Author authorDb = modelMapper.map(author, Author.class); //Verileri eşleştirdi
        authorDb = authorRepository.save(authorDb); //Veritabanına kaydet
        return modelMapper.map(authorDb, AuthorDto.class);
    }

    @Override
    public AuthorDto getById(Long id) {
        Author author=authorRepository.getOne(id);
        return modelMapper.map(author,AuthorDto.class);
    }


    @Override
    public TPage<AuthorDto> getAllPageable(Pageable pageable) {
        Page<Author> data=authorRepository.findAll(pageable);
        TPage page = new TPage<AuthorDto>();
        AuthorDto[] dtos=modelMapper.map(data.get(),AuthorDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(AuthorDto author) {
        return null;
    }

    public Boolean delete(Long id) {

        authorRepository.deleteById(id);
        return null;
    }
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public AuthorDto update(Long id, AuthorDto author) {
        Author authorDb = authorRepository.getOne(id);
        if(authorDb==null){
            throw  new IllegalArgumentException("Author doesnt exit");
        }
        authorDb.setN_sname(author.getN_sname());
        authorDb.setDescription(author.getDescription());
        authorRepository.save(authorDb);
        return  modelMapper.map(authorDb, AuthorDto.class);
    }
}
