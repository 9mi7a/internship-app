package org.example.internservice.services.impl;

import org.example.internservice.repositories.IInternRepository;
import org.example.internservice.services.IDeleteInternById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteInternByIdService implements IDeleteInternById {
    @Autowired
    IInternRepository internRepository;
    @Override
    public void delete(Long id) {
        try {
            internRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid intern ID");
        }
    }
}
