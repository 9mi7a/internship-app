package org.example.internservice.services.impl;

import org.example.internservice.models.requests.CreateInternRequest;
import org.example.internservice.models.responses.InternResponse;
import org.example.internservice.repositories.IInternRepository;
import org.example.internservice.repositories.entities.Intern;
import org.example.internservice.services.ICreateInternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateInternService implements ICreateInternService {
    @Autowired
    private IInternRepository internRepository;
    @Override
    public InternResponse create(CreateInternRequest request) {
        try {
            Intern newIntern = new Intern();
            newIntern.requestToIntern(request);
            Intern savedIntern = internRepository.save(newIntern);
            return savedIntern.toResponse();
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create intern: " + e.getMessage(), e);
        }
    }
}
