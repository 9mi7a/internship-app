package org.example.internshipservice.services.impl;

import org.example.internshipservice.models.responses.TopicResponse;
import org.example.internshipservice.repositories.ITopicRepository;
import org.example.internshipservice.repositories.entities.Topic;
import org.example.internshipservice.services.IGetTopicById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class GetTopicByidService implements IGetTopicById {
    @Autowired
    ITopicRepository topicRepository;

    @Override
    public Optional<Topic> getById(Long id) {
        return topicRepository.findById(id);
    }
    public Topic getByIdOrThrow(Long id) {
        return getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid topic ID"));
    }
}
