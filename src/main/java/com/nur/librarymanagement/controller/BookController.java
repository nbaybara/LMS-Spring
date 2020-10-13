package com.nur.librarymanagement.controller;

import com.nur.librarymanagement.dto.BookDto;

import java.util.List;

import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Book;
import com.nur.librarymanagement.service.*;
import com.nur.librarymanagement.service.implementation.AuthorServiceImpl;
import com.nur.librarymanagement.service.implementation.BookServiceImpl;
import com.nur.librarymanagement.service.implementation.PublisherServiceImpl;
import com.nur.librarymanagement.util.ApiPaths;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping("/{id}")
    public String getById(@PathVariable(value = "id", required = true) Long id , Model model) {
        final Book book = bookServiceImpl.getById(id);
        log.info(String.valueOf(book.getId()));
        model.addAttribute("book", book);
        return "list-book";
    }

    @RequestMapping("/list")
    public String getAll(Model theModel) {
        List<Book> books = bookService.findAllBooks();
        theModel.addAttribute("books", books);
        return "list-books";
    }

    @RequestMapping("/form-add")
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
        bookServiceImpl.save(book);
        model.addAttribute("book", bookServiceImpl.save(book));
        return "redirect:/api/book/list";
    }
    @GetMapping("/updateBook/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        final Book book = bookServiceImpl.getById(id);
        model.addAttribute("book",book);
        return "update-book";
    }

    @RequestMapping("/update-book/{id}")
    public String updateBook(@PathVariable("id") Long id, Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            return "update-book";
        }
        bookServiceImpl.update(id,book);
        model.addAttribute("book", bookServiceImpl.getAll());
        return "redirect:/api/book/list";
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable(value = "id", required = true) Long id, Model model) {
        model.addAttribute("author", bookServiceImpl.getAll());
        bookServiceImpl.delete(id);
        return "redirect:/api/book/list";
    }
    @RequestMapping("/searchBook")
    public String searchBook(@Param("keyword") String keyword, Model model) {
        final List<Book> books = bookService.searchBooks(keyword);
        model.addAttribute("books", books);
        model.addAttribute("keyword", keyword);
        return "list-books";
    }

}
