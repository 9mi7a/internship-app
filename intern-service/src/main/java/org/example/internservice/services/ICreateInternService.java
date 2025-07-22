package org.example.internservice.services;

import org.example.internservice.models.requests.CreateInternRequest;
import org.example.internservice.models.responses.InternResponse;

public interface ICreateInternService {
    InternResponse create(CreateInternRequest request);
}
