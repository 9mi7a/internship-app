package org.example.internshipservice.repositories;
import org.example.internshipservice.repositories.entities.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInternshipRepository extends JpaRepository<Internship, Long> {
}
