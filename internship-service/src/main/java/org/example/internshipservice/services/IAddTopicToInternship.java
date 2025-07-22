package org.example.internshipservice.services;

import org.example.internshipservice.models.responses.InternshipResponse;

public interface IAddTopicToInternship {
    InternshipResponse addTopicToInternship(Long TopicId, Long InternshipId);
}
