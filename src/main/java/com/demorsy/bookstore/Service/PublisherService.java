package com.demorsy.bookstore.Service;

import com.demorsy.bookstore.Entity.Publisher;
import com.demorsy.bookstore.Repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher getOnePublisherById(Long publisher_id){
        return publisherRepository.findById(publisher_id).orElse(null);
    }

    public Publisher savePublisher(Publisher newPublisher){
        return publisherRepository.save(newPublisher);
    }
}
