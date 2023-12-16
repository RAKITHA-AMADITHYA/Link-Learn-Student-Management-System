package edu.LearnLink.school.controller;

import edu.LearnLink.school.model.Student;
import edu.LearnLink.school.service.StudentServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceRepo studentServiceRepo;


    @GetMapping("/all")
    public ResponseEntity<List<Student>>getAllStudent(){
        List<Student>students=studentServiceRepo.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Student>getStudentsById(@PathVariable("id")Long id){
        Student student=studentServiceRepo.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudents(@RequestBody Student student){
            Student newStudent=studentServiceRepo.addStudent(student);
            return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateEmployee(@RequestBody Student student) {
        Student updateStudent = studentServiceRepo.updateStudent(student);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        studentServiceRepo.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
