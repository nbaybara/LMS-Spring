package com.nur.librarymanagement.controller;

import com.nur.librarymanagement.dto.BookDto;

import java.util.List;
import java.util.logging.Logger;

import com.nur.librarymanagement.entity.Book;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.service.*;
import com.nur.librarymanagement.util.ApiPaths;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@Repository
@AllArgsConstructor
@RequestMapping(ApiPaths.BookCtrl.CTRL)
public class BookController {
    private final BookServiceImpl bookServiceImpl;
    private final BookService bookService;
    private final AuthorServiceImpl authorServiceImpl;
    private final PublisherServiceImpl publisherServiceImpl;


    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getById(@PathVariable(value = "id", required = true) Long id) {
        BookDto bookDto = bookServiceImpl.getById(id);
        return ResponseEntity.ok(bookDto);
    }

    @RequestMapping("/list")
    public String getAll(Model theModel) {
        List<Book> books = bookService.findAllBooks();
        theModel.addAttribute("books", books);
        return "list-books";
    }

    @GetMapping("/form-add")
    public String showCreateForm(Book book, Model model) {
        model.addAttribute("authors", authorServiceImpl.getAll());
        model.addAttribute("publishers", publisherServiceImpl.getAll());
        return "add-book";
    }

    @PostMapping("/add-book")
    public String createBook(Book book, BindingResult result, Model model) {
        log.info("deneme");
        if (result.hasErrors()) {
            return result.toString();
        }
        bookService.save(book);
        model.addAttribute("book", bookService.findAllBooks());
        return "redirect:api/book/list";
    }

}
