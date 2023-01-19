package com.antra.homework.controller;


import com.antra.homework.pojo.Student;
import com.antra.homework.pojo.dto.StudentDTO;
import com.antra.homework.service.StudentService;
import com.antra.homework.service.impl.StudentServiceImpl;
import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {


    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public ResponseEntity<List<StudentDTO>> getAll(){
        return new ResponseEntity<>(studentService.get(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable int id){
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<StudentDTO> save(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<StudentDTO> update(@RequestBody Student student){
        studentService.update(student);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDTO> delete(@PathVariable int id){
        studentService.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
