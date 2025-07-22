package org.example.internshipservice.services;

import java.util.List;

public interface IGetInternsIdsByInternshipId {
    public List<Long> getInternsIdsByInternshipId(Long internshipId);
}
