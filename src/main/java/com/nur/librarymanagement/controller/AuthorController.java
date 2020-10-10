package com.nur.librarymanagement.controller;

import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.service.AuthorServiceImpl;
import com.nur.librarymanagement.util.ApiPaths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public Author getById(@PathVariable(value = "id", required = true) Long id) {
        return authorServiceImpl.getById(id);
    }

    @GetMapping("/list")
    public String getAll(Model theModel) {
        List<Author> authors = authorServiceImpl.getAll();
        theModel.addAttribute("authors", authors);
        return "list-authors";
    }

    @GetMapping("/addAuthor")
    public String showCreateForm(Author author) {
        return "add-author";
    }

    @RequestMapping("/add-author")
    public String createAuthor(@ModelAttribute("author") Author author, Model model) {
        log.info("author controller");
        authorServiceImpl.save(author);

        return "redirect:/api/author/list";
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(authorServiceImpl.delete(id));
    }

}
