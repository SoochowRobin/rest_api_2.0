package com.antra.homework.repository;

import com.antra.homework.pojo.Student_Course;
import com.antra.homework.pojo.dto.Student_CourseDTO;

public interface StudentCourseRepository {

    Student_CourseDTO getByStudentIdCourseId(int studentId, int courseId);

    void insert(Student_Course studentCourse);

    void deleteByStudentIdCourseId(int studentId, int courseId);

    void update(Student_Course studentCourse);
}
