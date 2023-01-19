package com.antra.homework.service;

import com.antra.homework.pojo.Course;
import com.antra.homework.pojo.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> getAll();

    CourseDTO getById(int id);

    void create(Course course);

    void update(Course course);

    void deleteById(int id);


}
