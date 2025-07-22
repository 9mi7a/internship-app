package org.example.internservice.models.responses;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record InternResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String university,
        String degree,
        String yearOfStudy,
        List<String> skills,
        List<String> languages,
        List<String> certifications,
        List<String> interests,
        Long currentInternshipId,
        Date joiningDate,
        LocalDateTime createdAt
) {}
