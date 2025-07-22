package org.example.internservice.repositories;
import org.example.internservice.repositories.entities.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInternRepository extends JpaRepository<Intern, Long> {
}
