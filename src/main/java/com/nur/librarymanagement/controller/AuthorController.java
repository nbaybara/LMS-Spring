package com.nur.librarymanagement.controller;

import com.nur.librarymanagement.dto.AuthorDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.service.implementation.AuthorServiceImpl;
import com.nur.librarymanagement.util.ApiPaths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(ApiPaths.AuthorCtrl.CTRL)
public class AuthorController {

    private AuthorServiceImpl authorServiceImpl;

    public AuthorController(AuthorServiceImpl authorServiceImpl) {
        this.authorServiceImpl = authorServiceImpl;
    }


    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id", required = true) Long id,Model model) {
        final Author author= authorServiceImpl.getById(id);
        model.addAttribute("author", author);
        return "list-authors";
    }

    @GetMapping("/list")
    public String getAll(Model theModel) {
        List<Author> authors = authorServiceImpl.getAll();
        theModel.addAttribute("authors", authors);
        return "list-authors";
    }

    @GetMapping("/addAuthor")
    public String showCreateForm(AuthorDto author) {
        return "add-author";
    }

    @RequestMapping("/add-author")
    public String createAuthor(AuthorDto author, Model model) {
        authorServiceImpl.save(author);
        return "redirect:/api/author/list";
    }
    @GetMapping("/updateAuthor/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        final Author author = authorServiceImpl.getById(id);
        model.addAttribute("author", author);
        return "update-author";
    }

    @RequestMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable("id") Long id, Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            author.setId(id);
            return "update-author";
        }
        log.info("author deneme");
        authorServiceImpl.update(id,author);
        model.addAttribute("author", authorServiceImpl.getAll());
        return "redirect:/api/author/list";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable(value = "id", required = true) Long id, Model model) {
        model.addAttribute("author", authorServiceImpl.getAll());
        authorServiceImpl.delete(id);
        return "redirect:/api/author/list";
    }

}
