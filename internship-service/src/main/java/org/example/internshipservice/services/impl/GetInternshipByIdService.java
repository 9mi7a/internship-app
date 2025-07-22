    package org.example.internshipservice.services.impl;
    import org.example.internshipservice.models.responses.InternshipResponse;
    import org.example.internshipservice.repositories.IInternshipRepository;
    import org.example.internshipservice.repositories.entities.Internship;
    import org.example.internshipservice.services.IGetInternshipById;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpHeaders;
    import org.springframework.http.HttpStatus;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.HttpClientErrorException;
    import org.springframework.web.server.ResponseStatusException;

    import java.nio.charset.StandardCharsets;

    @Service
    public class GetInternshipByIdService implements IGetInternshipById {
        @Autowired
        private IInternshipRepository internshipRepository;
        @Override
        public InternshipResponse getById(Long id) {
            if(internshipRepository.findById(id).isPresent())
                return internshipRepository.findById(id).get().toResponse();

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid internship ID");
        }
    }
