package com.nur.librarymanagement.controller;

import com.nur.librarymanagement.dto.AuthorDto;
import com.nur.librarymanagement.dto.BookDto;
import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Book;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.service.AuthorServiceImpl;
import com.nur.librarymanagement.service.BookServiceImpl;
import com.nur.librarymanagement.service.PublisherService;
import com.nur.librarymanagement.service.PublisherServiceImpl;
import com.nur.librarymanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Repository
@RequestMapping(ApiPaths.BookCtrl.CTRL)
public class BookController {
    private final BookServiceImpl bookServiceImpl;
    private final AuthorServiceImpl authorServiceImpl;
    private final PublisherServiceImpl publisherServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl, AuthorServiceImpl authorServiceImpl, PublisherServiceImpl publisherServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
        this.authorServiceImpl = authorServiceImpl;
        this.publisherServiceImpl = publisherServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getById(@PathVariable(value = "id", required = true) Long id) {
        BookDto bookDto = bookServiceImpl.getById(id);
        return ResponseEntity.ok(bookDto);
    }

    @PostMapping("add-book")
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto book) {
        return ResponseEntity.ok(bookServiceImpl.save(book));
    }


    @GetMapping("/add")
    public String showCreateForm(Book book, Model model) {
        List<Author> data = authorServiceImpl.getAll();
        //List<Publisher> data1 = publisherServiceImpl.getAll();
        model.addAttribute(data);
        //model.addAttribute(data1);
        return "add-book";
    }

    @GetMapping()
    public ResponseEntity<List<BookDto>> getAll() {
        List<BookDto> data = bookServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }
}
