package org.example.internshipservice.controller;


import org.example.internshipservice.models.requests.CreateInternshipRequest;
import org.example.internshipservice.models.requests.UpdateInternshipRequest;
import org.example.internshipservice.models.responses.InternshipResponse;
import org.example.internshipservice.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class InternshipController {

    @Autowired private CreateInternshipService createInternshipService;
    @Autowired private GetAllInternshipsService getAllInternshipsService;
    @Autowired private GetInternshipByIdService getInternshipByIdService;
    @Autowired private UpdateInternshipByIdService updateInternshipByIdService;
    @Autowired private DeleteInternshipByIdService deleteInternshipByIdService;
    @Autowired private AddInternToInternshipService addInternToInternshipService;
    @Autowired private GetInternsIdsByInternshipIdService getInternsIdsByInternshipIdService;
    @Autowired private AddTopicToInternshipService addTopicToInternshipService;
    @PostMapping
    public InternshipResponse create(@RequestBody CreateInternshipRequest request) {
        return createInternshipService.create(request);
    }

    @GetMapping
    public Page<InternshipResponse> getAll(Pageable pageable) {
        return getAllInternshipsService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public InternshipResponse getById(@PathVariable Long id) {
        return getInternshipByIdService.getById(id);
    }

    @PutMapping("/{id}")
    public InternshipResponse update(@PathVariable Long id, @RequestBody UpdateInternshipRequest request) {
        return updateInternshipByIdService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteInternshipByIdService.delete(id);
    }

    @PostMapping("/{id}/add-intern")
    public void addIntern(@PathVariable Long id, @RequestBody Long internId) {
         addInternToInternshipService.addInternToInternship(id, internId);
    }
    @GetMapping("/{id}/interns")
    public List<Long> getInternsIds(@PathVariable Long id, Pageable pageable) {
        return getInternsIdsByInternshipIdService.getInternsIdsByInternshipId(id);
    }
    @PostMapping("/{id}/add-topic")
    public InternshipResponse addTopic(@PathVariable Long id, @RequestBody Long topicId) {
       return addTopicToInternshipService.addTopicToInternship(id, topicId);
    }
}
