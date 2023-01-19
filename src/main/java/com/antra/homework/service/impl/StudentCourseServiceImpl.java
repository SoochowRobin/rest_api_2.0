package com.antra.homework.service.impl;

import com.antra.homework.pojo.Student_Course;
import com.antra.homework.pojo.dto.Student_CourseDTO;
import com.antra.homework.repository.StudentCourseRepository;
import com.antra.homework.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    private StudentCourseRepository studentCourseRepository;

    @Autowired
    public void setStudentCourseRepository(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public Student_CourseDTO getByStuIdCourseId(int stuId, int courseId) {
        return studentCourseRepository.getByStudentIdCourseId(stuId, courseId);
    }

    @Override
    @Transactional
    public void create(Student_Course studentCourse) {
        studentCourseRepository.insert(studentCourse);
    }

    @Override
    @Transactional
    public void deleteByStuIdCourseId(int stuId, int courseId) {
        studentCourseRepository.deleteByStudentIdCourseId(stuId, courseId);
    }

    @Override
    @Transactional
    public void update(Student_Course studentCourse) {
        studentCourseRepository.update(studentCourse);
    }
}
