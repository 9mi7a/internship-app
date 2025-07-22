package org.example.internshipservice.models.requests;

import org.example.internshipservice.repositories.entities.Topic;

import java.util.List;

public class CreateTopicRequest {
    private String title;
    private String description;
    private String minDurationInDays;
    private List<String> requiredSkills;
    private  List<String> keywords;

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

    public Topic toTopic() {
        Topic topic = new Topic();
        topic.setTitle(this.title);
        topic.setDescription(this.description);
        topic.setMinDurationInDays(this.minDurationInDays);
        topic.setRequiredSkills(this.requiredSkills);
        topic.setKeywords(this.keywords);
        return topic;
    }
}
