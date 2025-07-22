package org.example.internshipservice.models.responses;

import org.example.internshipservice.repositories.entities.Topic;

import java.util.List;

public record TopicResponse(
        String title,
        String description,
        String minDurationInDays,
        List<String> requiredSkills,

        List<String> keywords
) {

}
