package edu.LearnLink.school.controller;

import edu.LearnLink.school.model.Student;
import edu.LearnLink.school.service.StudentServiceRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
@Tag(name="Student Registration")
public class StudentController {
    @Autowired
    private StudentServiceRepo studentServiceRepo;


    @GetMapping("/all")
    @ApiResponse(responseCode = "200 Ok",description = "Standard response for successful HTTP requests. The actual response will depend on the request method used. In a GET request, the response will contain an entity corresponding to the requested resource. In a POST request, the response will contain an entity describing or containing the result of the action.")
    @ApiResponse(responseCode = "404 Not Found",description = "The requested resource could not be found but may be available in the future. Subsequent requests by the client are permissible..")
    @ApiResponse(responseCode = "500 Internal Server Error ",description = "A generic error message, given when an unexpected condition was encountered and no more specific message is suitable.")

    @Operation(description = "With this streamlined method, users gain the ability to effortlessly peruse the entire roster of students housed within the database.")
    public ResponseEntity<List<Student>>getAllStudent(){
        List<Student>students=studentServiceRepo.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @ApiResponse(responseCode = "200 Ok",description = "Standard response for successful HTTP requests. The actual response will depend on the request method used. In a GET request, the response will contain an entity corresponding to the requested resource. In a POST request, the response will contain an entity describing or containing the result of the action.")
    @ApiResponse(responseCode = "404 Not Found",description = "The requested resource could not be found but may be available in the future. Subsequent requests by the client are permissible..")
    @ApiResponse(responseCode = "500 Internal Server Error ",description = "A generic error message, given when an unexpected condition was encountered and no more specific message is suitable.")

    @Operation(description = "With this streamlined method, user can search students by their id.")
    public ResponseEntity<Student>getStudentsById(@PathVariable("id")Long id){
        Student student=studentServiceRepo.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiResponse(responseCode = "200 Ok",description = "Standard response for successful HTTP requests. The actual response will depend on the request method used. In a GET request, the response will contain an entity corresponding to the requested resource. In a POST request, the response will contain an entity describing or containing the result of the action.")
    @ApiResponse(responseCode = "404 Not Found",description = "The requested resource could not be found but may be available in the future. Subsequent requests by the client are permissible..")
    @ApiResponse(responseCode = "500 Internal Server Error ",description = "A generic error message, given when an unexpected condition was encountered and no more specific message is suitable.")

    @Operation(description = "With this streamlined method, user can add a new student to the database")
    public ResponseEntity<Student> addStudents(@RequestBody Student student){
            Student newStudent=studentServiceRepo.addStudent(student);
            return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiResponse(responseCode = "200 Ok",description = "Standard response for successful HTTP requests. The actual response will depend on the request method used. In a GET request, the response will contain an entity corresponding to the requested resource. In a POST request, the response will contain an entity describing or containing the result of the action.")
    @ApiResponse(responseCode = "404 Not Found",description = "The requested resource could not be found but may be available in the future. Subsequent requests by the client are permissible..")
    @ApiResponse(responseCode = "500 Internal Server Error ",description = "A generic error message, given when an unexpected condition was encountered and no more specific message is suitable.")

    @Operation(description = "With this streamlined method, user can update an added student.")
    public ResponseEntity<Student> updateEmployee(@RequestBody Student student) {
        Student updateStudent = studentServiceRepo.updateStudent(student);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponse(responseCode = "200 Ok",description = "Standard response for successful HTTP requests. The actual response will depend on the request method used. In a GET request, the response will contain an entity corresponding to the requested resource. In a POST request, the response will contain an entity describing or containing the result of the action.")
    @ApiResponse(responseCode = "404 Not Found",description = "The requested resource could not be found but may be available in the future. Subsequent requests by the client are permissible..")
    @ApiResponse(responseCode = "500 Internal Server Error ",description = "A generic error message, given when an unexpected condition was encountered and no more specific message is suitable.")

    @Operation(description = "With this streamlined method, users can delete a student.")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        studentServiceRepo.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
