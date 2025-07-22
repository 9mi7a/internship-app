package org.example.internshipservice.models.responses;

import org.example.internshipservice.repositories.entities.Topic;

import java.util.Date;
import java.util.List;

public record InternshipResponse(
        Long id,
        String title,
        String description,
        Date startDate,
        Date endDate,
        String type,
        List<Long> internsIds,
        TopicResponse topic
) {}
