package SpringbootREST.restapp.controller;

import SpringbootREST.restapp.model.student;
import SpringbootREST.restapp.repository.StudentRepository;
import SpringbootREST.restapp.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class StudentController {
    studentService studentservice;

    @Autowired
    public StudentController(studentService studentservice) {
        this.studentservice=studentservice;
    }

    public StudentController() {
    }

    @GetMapping("/students/{id}")
    @ResponseBody
    public ResponseEntity<student> getStudent(@PathVariable Long id){
       student s= studentservice.gStudent(id);
       System.out.println(s);
        return new ResponseEntity<student>(s,HttpStatus.OK);
    }
    @GetMapping("/students")
    @ResponseBody
    public ResponseEntity<List<student>> getAllStudents(){
       List<student>students  =new ArrayList<student>() ;
        students=studentservice.gStudents();

    return new ResponseEntity<List<student>>(students, HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    @ResponseBody
    public ResponseEntity<student> updateSstudent(@PathVariable Long id ,@RequestBody student s){
       student st= studentservice.updateStudent(id,s);
        return new ResponseEntity<student>(st,HttpStatus.OK);
    }

    @PostMapping("students")
    @ResponseBody
    public ResponseEntity<student> createStudent(@RequestBody student s){
        student st=studentservice.createStudent(s);
        return new ResponseEntity<student>(st,HttpStatus.OK);
    }

    @DeleteMapping("students/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentservice.deleteStudent(id);
        return new ResponseEntity("deleted",HttpStatus.OK);
    }
}
