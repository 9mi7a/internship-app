package org.example.internshipservice.controller;

import jakarta.ws.rs.GET;
import org.example.internshipservice.models.requests.CreateTopicRequest;
import org.example.internshipservice.models.responses.TopicResponse;
import org.example.internshipservice.services.impl.CreateTopicService;
import org.example.internshipservice.services.impl.GetTopicByidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
public class TopicController {
@Autowired private CreateTopicService createTopicService;
@Autowired private GetTopicByidService getTopicByidService;

@PostMapping
public TopicResponse createTopic(@RequestBody CreateTopicRequest request) {
    return createTopicService.create(request);
}
@GetMapping("/{id}")
public TopicResponse getTopicById(@PathVariable Long id) {
    return getTopicByidService.getByIdOrThrow(id).toResponse();
}
}

