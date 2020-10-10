package com.nur.librarymanagement.controller;

import com.nur.librarymanagement.dto.AuthorDto;
import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.service.AuthorServiceImpl;
import com.nur.librarymanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(ApiPaths.AuthorCtrl.CTRL)
public class AuthorController {

    private AuthorServiceImpl authorServiceImpl;

    public AuthorController(AuthorServiceImpl authorServiceImpl) {
        this.authorServiceImpl = authorServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getById(@PathVariable(value = "id", required = true) Long id) {
        AuthorDto authorDto = authorServiceImpl.getById(id);
        return ResponseEntity.ok(authorDto);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody AuthorDto author) {
        return ResponseEntity.ok(authorServiceImpl.save(author));
    }
    @GetMapping("/list")
    public String  getAll(Model theModel) {
        List<Author> authors = authorServiceImpl.getAll();
        theModel.addAttribute("authors",authors);
        return   "list-authors";
    }


    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable(value = "id", required = true) Long id,
                                                  @Valid @RequestBody AuthorDto author) {
        return ResponseEntity.ok(authorServiceImpl.update(id, author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(authorServiceImpl.delete(id));
    }

}
