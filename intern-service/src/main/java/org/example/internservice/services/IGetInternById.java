package org.example.internservice.services;
import org.example.internservice.models.responses.InternResponse;
public interface IGetInternById {
    InternResponse getById(Long id);

}
