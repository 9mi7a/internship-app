package org.example.internservice.services.impl;

import org.example.internservice.models.responses.InternResponse;
import org.example.internservice.repositories.IInternRepository;
import org.example.internservice.repositories.entities.Intern;
import org.example.internservice.services.IGetInternById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetInternByIdService implements IGetInternById {
    @Autowired
    IInternRepository internRepository;

    @Override
    public InternResponse getById(Long id) {
        Intern intern = internRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid intern ID"));
        return intern.toResponse();
    }
}
