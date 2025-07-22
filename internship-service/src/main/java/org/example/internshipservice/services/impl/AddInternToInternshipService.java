package org.example.internshipservice.services.impl;

import org.example.internshipservice.repositories.IInternshipRepository;
import org.example.internshipservice.services.IAddInternToInternship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AddInternToInternshipService implements IAddInternToInternship {
    @Autowired
    private IInternshipRepository internshipRepository;
    @Override
    public void addInternToInternship(Long internshipId, Long internId) {
        var internship = internshipRepository.findById(internshipId)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid internship ID"));
        if (!internship.getInternsIds().contains(internId)) {
            internship.getInternsIds().add(internId);
            internshipRepository.save(internship);
        }
    }
}
