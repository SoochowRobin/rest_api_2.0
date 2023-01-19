package com.antra.homework.controller;

import com.antra.homework.pojo.Course;
import com.antra.homework.pojo.dto.CourseDTO;
import com.antra.homework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAll(){
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable int id){
        return new ResponseEntity<>(courseService.getById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CourseDTO> create(@RequestBody Course course){
        courseService.create(course);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseDTO> deleteById(@PathVariable int id){
        courseService.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CourseDTO> update(@RequestBody Course course){
        courseService.update(course);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
