package org.example.internshipservice.services;

import org.example.internshipservice.models.requests.CreateInternshipRequest;
import org.example.internshipservice.models.responses.InternshipResponse;
public interface ICreateInternshipService {
    InternshipResponse create(CreateInternshipRequest request);
}
