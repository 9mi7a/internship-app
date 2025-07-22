package org.example.internservice.services.impl;

import org.example.internservice.models.responses.InternResponse;
import org.example.internservice.repositories.IInternRepository;
import org.example.internservice.repositories.entities.Intern;
import org.example.internservice.services.IGetAllInterns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class GetAllInternsService implements IGetAllInterns {
    @Autowired
    IInternRepository internRepository;

    @Override
    public Page<InternResponse> getAll(Pageable pageable) {
        return internRepository.findAll(pageable)
                .map(Intern::toResponse);
    }


}
