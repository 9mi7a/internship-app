package org.example.internshipservice.services.impl;

import org.example.internshipservice.models.responses.InternshipResponse;
import org.example.internshipservice.repositories.IInternshipRepository;
import org.example.internshipservice.repositories.ITopicRepository;
import org.example.internshipservice.repositories.entities.Internship;
import org.example.internshipservice.repositories.entities.Topic;
import org.example.internshipservice.services.IAddTopicToInternship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AddTopicToInternshipService implements IAddTopicToInternship {
@Autowired
    IInternshipRepository internshipRepository;
@Autowired
    GetTopicByidService getTopicByidService;
    @Override
    public InternshipResponse addTopicToInternship(Long TopicId, Long InternshipId) {
        Topic topic = getTopicByidService.getById(TopicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid internship ID"));
        Internship internship = internshipRepository.findById(InternshipId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid internship ID"));
        internship.setTopic(topic);
        internship = internshipRepository.save(internship);
        return internship.toResponse();
    }

}
