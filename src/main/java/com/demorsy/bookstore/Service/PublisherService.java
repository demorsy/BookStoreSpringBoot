package com.demorsy.bookstore.Service;

import com.demorsy.bookstore.Dto.ResponsePublisherDto;
import com.demorsy.bookstore.Entity.Publisher;
import com.demorsy.bookstore.Mapper.PublisherDtoMapper;
import com.demorsy.bookstore.Repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;
    private PublisherDtoMapper publisherDtoMapper;

    public PublisherService(PublisherDtoMapper publisherDtoMapper, PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
        this.publisherDtoMapper = publisherDtoMapper;
    }

    public ResponsePublisherDto getOnePublisherById(Long publisher_id){
        //return publisherRepository.findById(publisher_id).orElse(null);

        Publisher foundPublisher = publisherRepository.findById(publisher_id).orElse(null);
        if(foundPublisher != null){
            return publisherDtoMapper.convertPublisherToPublisherDto(foundPublisher);
        }else{
            return null;
        }
    }

    public Publisher savePublisher(Publisher newPublisher){
        return publisherRepository.save(newPublisher);
    }
}
