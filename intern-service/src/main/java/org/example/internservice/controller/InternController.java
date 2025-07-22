package org.example.internservice.controller;

import org.example.internservice.models.requests.CreateInternRequest;
import org.example.internservice.models.requests.UpdateInternRequest;
import org.example.internservice.models.responses.InternResponse;
import org.example.internservice.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class InternController {

    @Autowired private CreateInternService createInternService;
    @Autowired private GetAllInternsService getAllInternsService;
    @Autowired private GetInternByIdService getInternByIdService;
    @Autowired private UpdateInternByIdService updateInternByIdService;
    @Autowired private DeleteInternByIdService deleteInternByIdService;
    @Autowired private GetInternsByinternshipIdService getInternsByInternshipIdService;

    @PostMapping
    public InternResponse create(@RequestBody CreateInternRequest request) {
        return createInternService.create(request);
    }

    @GetMapping
    public Page<InternResponse> getAll(Pageable pageable) {
        return getAllInternsService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public InternResponse getById(@PathVariable Long id) {
        return getInternByIdService.getById(id);
    }

    @PutMapping("/{id}")
    public InternResponse update(@PathVariable Long id, @RequestBody UpdateInternRequest request) {
        return updateInternByIdService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteInternByIdService.delete(id);
    }

    @GetMapping("/getInternsByInternshipId/{internshipId}")
    public List<InternResponse> getInternsByInternshipId(@PathVariable Long internshipId) {
        return getInternsByInternshipIdService.getByInternshipId(internshipId);
    }
}
