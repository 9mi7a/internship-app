package org.example.internshipservice.repositories.entities;

import jakarta.persistence.*;
import org.example.internshipservice.models.responses.TopicResponse;

import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minDurationInDays;
    @ElementCollection
    private List<String> requiredSkills;
    @ElementCollection
    private  List<String> keywords;

    public Long getId() {
        return id;
    }

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

    public String getMinDurationInDays() {
        return minDurationInDays;
    }

    public void setMinDurationInDays(String minDurationInDays) {
        this.minDurationInDays = minDurationInDays;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
    public TopicResponse toResponse() {
        return new TopicResponse(
                title,
                description,
                minDurationInDays,
                requiredSkills,
                keywords
        );
    }
}
