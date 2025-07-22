package org.example.internservice.services.impl;

import org.example.internservice.models.requests.CreateInternRequest;
import org.example.internservice.models.requests.UpdateInternRequest;
import org.example.internservice.models.responses.InternResponse;
import org.example.internservice.repositories.IInternRepository;
import org.example.internservice.repositories.entities.Intern;
import org.example.internservice.services.IUpdateInternById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateInternByIdService implements IUpdateInternById {
    @Autowired
    IInternRepository internRepository;

    @Override
    public InternResponse update(Long id, UpdateInternRequest request) {
        Intern intern = internRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid intern ID"));
        if (request.getFirstName() != null) intern.setFirstName(request.getFirstName());
        if (request.getLastName() != null) intern.setLastName(request.getLastName());
        if (request.getEmail() != null) intern.setEmail(request.getEmail());
        if (request.getPhoneNumber() != null) intern.setPhoneNumber(request.getPhoneNumber());
        if (request.getUniversity() != null) intern.setUniversity(request.getUniversity());
        if (request.getDegree() != null) intern.setDegree(request.getDegree());
        if (request.getYearOfStudy() != null) intern.setYearOfStudy(request.getYearOfStudy());
        if (request.getSkills() != null) intern.setSkills(request.getSkills());
        if (request.getLanguages() != null) intern.setLanguages(request.getLanguages());
        if (request.getCertifications() != null) intern.setCertifications(request.getCertifications());
        if (request.getInterests() != null) intern.setInterests(request.getInterests());
        if (request.getCurrentInternshipId() != null) intern.setCurrentInternshipId(request.getCurrentInternshipId());
        if (request.getJoiningDate() != null) intern.setJoiningDate(request.getJoiningDate());
        Intern updatedIntern = internRepository.save(intern);
        return updatedIntern.toResponse();
    }
}
