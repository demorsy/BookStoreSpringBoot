package com.demorsy.bookstore.Mapper;

import com.demorsy.bookstore.Dto.ResponsePublisherDto;
import com.demorsy.bookstore.Entity.Publisher;
import org.springframework.stereotype.Service;

@Service
public class PublisherDtoMapper {

    public PublisherDtoMapper() {
    }

    public ResponsePublisherDto convertPublisherToPublisherDto(Publisher publisher){
        ResponsePublisherDto responsePublisherDto = new ResponsePublisherDto(
                publisher.getName(),
                publisher.getDescription()
        );

        return responsePublisherDto;
    }
}
