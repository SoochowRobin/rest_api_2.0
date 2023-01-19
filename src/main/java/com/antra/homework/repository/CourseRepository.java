package com.antra.homework.repository;

import com.antra.homework.pojo.Course;
import com.antra.homework.pojo.dto.CourseDTO;

import java.util.List;

public interface CourseRepository {

    List<CourseDTO> getAll();

    CourseDTO getById(int id);

    void create(Course course);

    void update(Course course);

    void deleteById(int id);

}
