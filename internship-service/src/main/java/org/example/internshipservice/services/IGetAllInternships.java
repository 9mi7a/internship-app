package org.example.internshipservice.services;
import org.example.internshipservice.models.responses.InternshipResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGetAllInternships {
    Page<InternshipResponse> getAll(Pageable pageable);
}
