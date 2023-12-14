package edu.LearnLink.school.service;

import edu.LearnLink.school.model.Student;

import java.util.List;

public interface StudentServiceRepo {
    public Student addStudent(Student student);
    public List<Student> findAllStudents();

    public Student findStudentById(Long id);

    public Student updateStudent(Student student);
    public void deleteStudent(Long id);
}
