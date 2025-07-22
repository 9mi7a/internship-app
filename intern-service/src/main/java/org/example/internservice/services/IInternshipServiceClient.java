package org.example.internservice.services;

import java.util.List;

public interface IInternshipServiceClient {
    List<Long> getInternIdsByInternshipId(Long internshipId);
}