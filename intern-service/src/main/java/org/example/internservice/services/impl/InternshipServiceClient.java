package org.example.internservice.services.impl;

import org.example.internservice.services.IInternshipServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class InternshipServiceClient implements IInternshipServiceClient {
    @Autowired
    private  RestTemplate restTemplate;

    @Override
    public List<Long> getInternIdsByInternshipId(Long internshipId) {
        try {
            ResponseEntity<List<Long>> response = restTemplate.exchange(
                    "http://internship-service/" + internshipId + "/interns",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );
            return response.getBody();
        } catch (RestClientException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid internship ID");
        }
    }
}
