package edu.LearnLink.school.service;

import edu.LearnLink.school.exeption.UserNotFoundException;
import edu.LearnLink.school.model.Student;
import edu.LearnLink.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentServiceRepo{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
       student.setStudentId(UUID.randomUUID().toString());
       return studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found"));
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
         studentRepository.deleteById(id);
    }

}
