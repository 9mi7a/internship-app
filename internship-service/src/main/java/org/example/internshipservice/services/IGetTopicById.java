package org.example.internshipservice.services;

import org.example.internshipservice.models.responses.TopicResponse;
import org.example.internshipservice.repositories.entities.Topic;

import java.util.Optional;

public interface IGetTopicById {
    Optional<Topic> getById(Long id);
}
