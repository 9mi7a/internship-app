package org.example.internshipservice.services;
import org.example.internshipservice.models.responses.InternshipResponse;
import org.example.internshipservice.repositories.entities.Internship;

public interface IGetInternshipById {
    InternshipResponse getById(Long id);

}
