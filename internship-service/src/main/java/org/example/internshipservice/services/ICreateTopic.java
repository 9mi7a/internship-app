package org.example.internshipservice.services;

import org.example.internshipservice.models.requests.CreateTopicRequest;
import org.example.internshipservice.models.responses.TopicResponse;

public interface ICreateTopic {
    TopicResponse create(CreateTopicRequest request);
}
