package org.example.internshipservice.services.impl;

import org.example.internshipservice.models.requests.UpdateInternshipRequest;
import org.example.internshipservice.models.responses.InternshipResponse;
import org.example.internshipservice.repositories.IInternshipRepository;
import org.example.internshipservice.repositories.entities.Internship;
import org.example.internshipservice.services.IUpdateInternshipById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateInternshipByIdService implements IUpdateInternshipById {
    @Autowired
    private IInternshipRepository internshipRepository;
    @Override
    public InternshipResponse update(Long id, UpdateInternshipRequest request) {
        Internship internship = internshipRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid internship ID"));
        if (request.getTitle() != null) {
            internship.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            internship.setDescription(request.getDescription());
        }
        if (request.getEndDate() != null) {
            internship.setEndDate(request.getEndDate());
        }
        if (request.getStartDate() != null) {
            internship.setStartDate(request.getStartDate());
        }
        if (request.getInternsIds()!= null) {
            internship.setInternsIds(request.getInternsIds());
        }
        if (request.getType()!= null) {
            internship.setType(request.getType());
        }

        Internship updatedIntern = internshipRepository.save(internship);
        return updatedIntern.toResponse();
    }
}
