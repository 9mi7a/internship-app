package org.example.internshipservice.services;
import org.example.internshipservice.models.requests.CreateInternshipRequest;
import org.example.internshipservice.models.requests.UpdateInternshipRequest;
import org.example.internshipservice.models.responses.InternshipResponse;
import org.example.internshipservice.repositories.entities.Internship;

public interface IUpdateInternshipById {
    InternshipResponse update(Long id, UpdateInternshipRequest request);


}
