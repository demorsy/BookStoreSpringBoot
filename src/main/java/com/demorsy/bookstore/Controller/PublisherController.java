package com.demorsy.bookstore.Controller;

import com.demorsy.bookstore.Entity.Publisher;
import com.demorsy.bookstore.Service.PublisherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/{publisher_id}")
    public Publisher getOnePublisherById(Long publisher_id){
        return publisherService.getOnePublisherById(publisher_id);
    }

    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher newPublisher){
        return publisherService.savePublisher(newPublisher);
    }
}
