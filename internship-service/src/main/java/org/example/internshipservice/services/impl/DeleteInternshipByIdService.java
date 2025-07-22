package org.example.internshipservice.services.impl;

import org.example.internshipservice.repositories.IInternshipRepository;
import org.example.internshipservice.services.IDeleteInternshipById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteInternshipByIdService implements IDeleteInternshipById {
    @Autowired
    private IInternshipRepository internshipRepository;    @Override
    public void delete(Long id) {
        try {
            internshipRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid internship ID");
        }
    }
}
