package org.example.internshipservice.services.impl;

import org.example.internshipservice.models.responses.InternshipResponse;
import org.example.internshipservice.repositories.IInternshipRepository;
import org.example.internshipservice.repositories.entities.Internship;
import org.example.internshipservice.services.IGetAllInternships;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class GetAllInternshipsService implements IGetAllInternships {
    @Autowired
    private IInternshipRepository internshipRepository;

    @Override
    public Page<InternshipResponse> getAll(Pageable pageable) {
        return internshipRepository.findAll(pageable)
                .map(Internship::toResponse);
    }


}
