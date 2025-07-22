package org.example.internservice.services;
import org.example.internservice.models.requests.CreateInternRequest;
import org.example.internservice.models.requests.UpdateInternRequest;
import org.example.internservice.models.responses.InternResponse;
public interface IUpdateInternById {
    InternResponse update(Long id, UpdateInternRequest request);


}
