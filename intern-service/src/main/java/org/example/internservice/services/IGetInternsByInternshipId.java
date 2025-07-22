package org.example.internservice.services;

import org.example.internservice.models.responses.InternResponse;
import java.util.List;
public interface IGetInternsByInternshipId {
    public List<InternResponse> getByInternshipId(Long internshipId);

}
