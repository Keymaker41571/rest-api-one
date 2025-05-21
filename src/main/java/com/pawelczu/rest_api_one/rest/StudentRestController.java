package com.pawelczu.rest_api_one.rest;

import com.pawelczu.rest_api_one.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("KonradOne", "p"));
        theStudents.add(new Student("KonradTwo", "p"));
        theStudents.add(new Student("KonradThree", "p"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if(studentId >= theStudents.size() ||  (studentId < 0))  {
            throw new StudentNotFoundException("Student id not found... " + studentId);
        }

        return theStudents.get(studentId);
    }
}







