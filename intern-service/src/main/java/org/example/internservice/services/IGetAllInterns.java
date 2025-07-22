package org.example.internservice.services;
import org.example.internservice.models.responses.InternResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGetAllInterns {
    Page<InternResponse> getAll(Pageable pageable);
}
