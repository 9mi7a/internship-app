package org.example.internshipservice.services.impl;


import org.example.internshipservice.models.requests.CreateInternshipRequest;
import org.example.internshipservice.models.responses.InternshipResponse;
import org.example.internshipservice.repositories.entities.Internship;
import org.example.internshipservice.services.ICreateInternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.internshipservice.repositories.IInternshipRepository;
@Service
public class CreateInternshipService implements ICreateInternshipService {
    @Autowired
    private IInternshipRepository internshipRepository;
    @Override
    public InternshipResponse create(CreateInternshipRequest request) {
        try {
            Internship newInternship = new Internship();
            newInternship.requestToInternship(request);
            Internship savedInternship = internshipRepository.save(newInternship);
            return savedInternship.toResponse();
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create intern: " + e.getMessage(), e);
        }
    }
}
