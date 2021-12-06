package SpringbootREST.restapp.service;

import java.util.List;

import SpringbootREST.restapp.model.student;

public interface studentService {

     List<student> gStudents();
     student gStudent(Long id);
     student updateStudent(Long id,student s);
     student createStudent(student s);
     void deleteStudent(Long id);
}