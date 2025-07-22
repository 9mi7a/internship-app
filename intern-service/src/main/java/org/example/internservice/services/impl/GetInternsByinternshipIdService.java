package org.example.internservice.services.impl;

import org.example.internservice.models.responses.InternResponse;
import org.example.internservice.repositories.IInternRepository;
import org.example.internservice.services.IGetInternsByInternshipId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetInternsByinternshipIdService implements IGetInternsByInternshipId {
    @Autowired
    IInternRepository internRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired GetInternByIdService getInternByIdService;
    @Autowired InternshipServiceClient internshipServiceClient;
    @Override
    public List<InternResponse> getByInternshipId(Long internshipId) {
        try {

        List<Long> internsIds =internshipServiceClient.getInternIdsByInternshipId(internshipId);
        List<InternResponse> interns = new ArrayList<>();
        for (Long internId:internsIds){
            InternResponse intern= getInternByIdService.getById(internId);
            if (intern != null) {
                interns.add(intern);
            }
        }
        return interns;
    }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid internship ID");
        }
    }
}
