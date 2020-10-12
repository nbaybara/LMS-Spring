package com.nur.librarymanagement.controller;

import com.nur.librarymanagement.dto.PublisherDto;
import com.nur.librarymanagement.entity.Publisher;
import com.nur.librarymanagement.service.PublisherService;
import com.nur.librarymanagement.service.implementation.PublisherServiceImpl;
import com.nur.librarymanagement.util.ApiPaths;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        theModel.addAttribute("publishers", publishers);
        return "list-publishers";
    }

    @GetMapping("/addPublisher")
    public String showCreateForm(PublisherDto publisher) {
        return "add-publisher";
    }

    @RequestMapping("/add-publisher")
    public String createPublisher(PublisherDto publisher, Model model) {
        publisherServiceImpl.save(publisher);
        return "redirect:/api/publisher/list";
    }

    @GetMapping("/updatePublisher/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        final Publisher publisher = publisherServiceImpl.getById(id);
        model.addAttribute("publisher", publisher);
        return "update-publisher";
    }

    @RequestMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable("id") Long id, Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            publisher.setId(id);
            return "update-publisher";
        }
        publisherServiceImpl.update(id, publisher);
        model.addAttribute("publisher", publisherServiceImpl.getAll());
        return "redirect:/api/publisher/list";
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable(value = "id", required = true) Long id,Model model){
        model.addAttribute("publisher", publisherServiceImpl.getAll());
        publisherServiceImpl.delete(id);
        return "redirect:/api/publisher/list";
    }


}
