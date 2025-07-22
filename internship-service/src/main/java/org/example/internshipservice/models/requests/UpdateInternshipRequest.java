package org.example.internshipservice.models.requests;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public class UpdateInternshipRequest {

    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String type;
    @ElementCollection
    private List<Long> internsIds;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getType() {
        return type;
    }

    public List<Long> getInternsIds() {
        return internsIds;
    }
}
