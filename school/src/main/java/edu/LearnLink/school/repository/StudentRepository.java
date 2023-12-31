package edu.LearnLink.school.repository;

import edu.LearnLink.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentById(Long id);
}

