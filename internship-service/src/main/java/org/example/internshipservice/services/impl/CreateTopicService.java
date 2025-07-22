package org.example.internshipservice.services.impl;

import org.example.internshipservice.models.requests.CreateTopicRequest;
import org.example.internshipservice.models.responses.TopicResponse;
import org.example.internshipservice.repositories.ITopicRepository;
import org.example.internshipservice.repositories.entities.Topic;
import org.example.internshipservice.services.ICreateTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateTopicService implements ICreateTopic {
    @Autowired
    ITopicRepository topicRepository;

    @Override
    public TopicResponse create(CreateTopicRequest request) {
        try {
            Topic newTopic = request.toTopic();
            Topic savedTopic = topicRepository.save(newTopic);
            return savedTopic.toResponse();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create topic: " + e.getMessage(), e);
        }
    }
}
