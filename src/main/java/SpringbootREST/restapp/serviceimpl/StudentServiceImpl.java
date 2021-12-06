package SpringbootREST.restapp.serviceimpl;

import SpringbootREST.restapp.exception.ExceptionKhasa;
import SpringbootREST.restapp.model.student;
import SpringbootREST.restapp.repository.StudentRepository;
import SpringbootREST.restapp.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentServiceImpl implements studentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<student> gStudents() {
      List<student> students = new ArrayList<student>(studentRepository.findAll()) ;

        return students;
    }

    @Override
    public student gStudent(Long id) {
        Optional<student> s;

            s=studentRepository.findById(id);
            if(s.isPresent()){
                return s.get();
            }else{

                throw  new ExceptionKhasa("No student with id ="+id);

            }
//or   return studentRepository.findById(id).orElseThrow(()-> new ExceptionKhasa("famesh"));



    }

    @Override
    public student updateStudent(Long id,student s) {
        student st;
        st=studentRepository.findById(id).orElseThrow(()->new ExceptionKhasa("wiou"));
        st.setName(s.getName());
        st.setPhone(s.getPhone());

        studentRepository.save(st);
        studentRepository.flush();


        return st;
    }

    @Override
    public student createStudent(student s) {
            student st=new student();
            st.setPhone(s.getPhone());
            st.setName(s.getName());
            studentRepository.save(s);
            studentRepository.flush();
            return s;

    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.findById(id).orElseThrow(()->new ExceptionKhasa("not found"));
        studentRepository.deleteById(id);

    }
}
