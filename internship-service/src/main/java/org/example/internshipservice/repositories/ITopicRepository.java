package org.example.internshipservice.repositories;

import org.example.internshipservice.repositories.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicRepository extends JpaRepository<Topic, Long> {

}
