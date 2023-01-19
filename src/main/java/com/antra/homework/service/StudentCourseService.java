package com.antra.homework.service;

import com.antra.homework.pojo.Student_Course;
import com.antra.homework.pojo.dto.Student_CourseDTO;

public interface StudentCourseService {

    Student_CourseDTO getByStuIdCourseId(int stuId, int courseId);

    void create(Student_Course studentCourse);

    void deleteByStuIdCourseId(int stuId, int courseId);

    void update(Student_Course studentCourse);

}
