package org.example.internshipservice.models.responses;

import java.util.Date;
import java.util.List;

public record InternshipResponse(
        String title,
                 String description,
                 Date startDate,
                 Date endDate,
                 String type,
                 List<Long> internsIds
) {}
