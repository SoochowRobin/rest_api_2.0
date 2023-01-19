package com.antra.homework.controller;

import com.antra.homework.pojo.Student_Course;
import com.antra.homework.pojo.dto.Student_CourseDTO;
import com.antra.homework.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentCourseController {

    private StudentCourseService studentCourseService;

    @Autowired
    public void setStudentCourseService(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @GetMapping("/students/{sid}/courses/{cid}")
    public ResponseEntity<Student_CourseDTO> getByStuIdCourseId(@PathVariable int sid, @PathVariable int cid){
        return new ResponseEntity<>(studentCourseService.getByStuIdCourseId(sid, cid), HttpStatus.OK);
    }


    /**
     * try to update, json是传入的是 student, 还是stu_id?
     *
     * {
     *     "id": 1,
     *     "stu_id": 2,
     *     "course_id": 2,
     *     "score": 70.0
     * }
     *
     *
     * Cannot invoke "com.antra.homework.pojo.Course.getId()"
     * because the return value of "com.antra.homework.pojo.Student_Course.getCourse()" is null
     */

    @PutMapping("/students/courses")
    public ResponseEntity<Student_CourseDTO> update(@RequestBody Student_Course studentCourse){
        studentCourseService.update(studentCourse);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /*
     要用merge才不会报错，但是会有null 为啥？
     */

    @PostMapping("/students/courses")
    public ResponseEntity<Student_CourseDTO> create(@RequestBody Student_Course studentCourse){
        studentCourseService.create(studentCourse);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/students/{sid}/courses/{cid}")
    public ResponseEntity<Student_CourseDTO> deleteByStuIdCourseId(@PathVariable int sid, @PathVariable int cid){
        studentCourseService.deleteByStuIdCourseId(sid, cid);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
