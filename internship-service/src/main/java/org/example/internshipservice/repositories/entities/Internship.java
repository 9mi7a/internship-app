package org.example.internshipservice.repositories.entities;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.example.internshipservice.models.requests.CreateInternshipRequest;
import org.example.internshipservice.models.requests.CreateInternshipRequest;
import org.example.internshipservice.models.responses.InternshipResponse;
import org.example.internshipservice.models.responses.InternshipResponse;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name = "internship")
//@ValidDateRange(start = "startDate", end = "endDate")
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String type;
    @ElementCollection
    private List<Long> internsIds;
//    private Topic topic;
//    private Supervisor supervisor;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Long> getInternsIds() {
        return internsIds;
    }

    public void setInternsIds(List<Long> internsIds) {
        this.internsIds = internsIds;
    }
    public void requestToInternship(CreateInternshipRequest request){
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.startDate = request.getStartDate();
        this.endDate = request.getEndDate();
        this.type = request.getType();
        this.internsIds = request.getInternsIds();
    }
    public InternshipResponse toResponse() {
        return new InternshipResponse(
                this.title,
                this.description,
                this.startDate,
                this.endDate,
                this.type,
                this.internsIds
        );
    }
}