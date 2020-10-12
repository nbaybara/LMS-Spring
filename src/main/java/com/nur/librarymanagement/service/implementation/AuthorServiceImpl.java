package com.nur.librarymanagement.service.implementation;

import com.nur.librarymanagement.dto.AuthorDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.repository.AuthorRepository;
import com.nur.librarymanagement.service.AuthorService;
import com.nur.librarymanagement.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        Author p = modelMapper.map(author, Author.class);
        p = authorRepository.save(p);
        author.setId(p.getId());
        return author;
    }

    @Override
    public Author getById(Long id) {

        return authorRepository.getOne(id);
    }

    @Override
    public Boolean delete(Author author) {
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
    public Author update(Long id, Author author) {
        Author authorDb = authorRepository.getOne(id);
        if(authorDb==null){
            throw  new IllegalArgumentException("Author doesnt exit");
        }
        authorDb.setN_sname(author.getN_sname());
        authorDb.setDescription(author.getDescription());
        return authorRepository.save(authorDb);

    }
}
