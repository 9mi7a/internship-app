package org.example.internshipservice.services.impl;

import org.example.internshipservice.repositories.IInternshipRepository;
import org.example.internshipservice.repositories.entities.Internship;
import org.example.internshipservice.services.IGetInternsIdsByInternshipId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class GetInternsIdsByInternshipIdService implements IGetInternsIdsByInternshipId {
    @Autowired
    private IInternshipRepository internshipRepository;
    @Override
    public List<Long>   getInternsIdsByInternshipId(Long internshipId) {
        return internshipRepository.findById(internshipId)
                .map(Internship::getInternsIds)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid internship ID"));

    }
}
