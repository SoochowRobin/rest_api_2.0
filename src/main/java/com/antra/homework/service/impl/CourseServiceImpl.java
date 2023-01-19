package com.antra.homework.service.impl;

import com.antra.homework.exception.ResourceNotFoundException;
import com.antra.homework.pojo.Course;
import com.antra.homework.pojo.dto.CourseDTO;
import com.antra.homework.repository.CourseRepository;
import com.antra.homework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public CourseDTO getById(int id) {

        // 在这边处理合适吗？ 但还是返回的是 No Result found ....
        CourseDTO courseDTO = null;
        try {
             courseDTO= courseRepository.getById(id);
        }catch (NullPointerException e){
            throw new ResourceNotFoundException("Course Not find ");
        }

        return courseDTO;
    }

    @Override
    @Transactional
    public void create(Course course) {
        courseRepository.create(course);
    }

    @Override
    @Transactional
    public void update(Course course) {
        courseRepository.update(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }
}
