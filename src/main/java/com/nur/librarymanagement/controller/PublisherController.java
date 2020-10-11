package com.nur.librarymanagement.controller;

import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.service.PublisherService;
import com.nur.librarymanagement.service.PublisherServiceImpl;
import com.nur.librarymanagement.util.ApiPaths;
import com.nur.librarymanagement.util.TPage;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(ApiPaths.PublisherCtrl.CTRL)
public class PublisherController {

    private final PublisherServiceImpl publisherServiceImpl;
    private final PublisherService publisherService;

    public PublisherController(PublisherServiceImpl publisherServiceImpl, PublisherService publisherService) {
        this.publisherServiceImpl = publisherServiceImpl;
        this.publisherService = publisherService;
    }

    @GetMapping("/list")
    public String getAll(Model theModel) {
        List<Publisher> publishers = publisherService.getAll();
        theModel.addAttribute("publishers" ,publishers);
        return "list-publishers";
    }

    @GetMapping("/addPublisher")
    public String showCreateForm(PublisherDto publisher) {
        return "add-publisher";
    }

    @RequestMapping("/add-publisher")
    public String createAuthor(PublisherDto publisher,  Model model) {
        publisherServiceImpl.save(publisher);
        return "redirect:/api/publisher/list";
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDto> getById(@PathVariable(value="id",required = true) Long id){
        PublisherDto publisherDto = publisherServiceImpl.getById(id);
        return ResponseEntity.ok(publisherDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PublisherDto> updateProject(@PathVariable(value = "id", required = true) Long id,
                                                      @Valid @RequestBody PublisherDto publisher) {
        return ResponseEntity.ok(publisherServiceImpl.update(id, publisher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(publisherServiceImpl.delete(id));
    }


}
