package com.antra.homework.pojo.dto;

import com.antra.homework.pojo.Course;
import lombok.Data;

@Data
public class CourseDTO {
    private String name;

    private String instructor;

    public CourseDTO(Course c){
        this.name = c.getName();
        this.instructor = c.getInstructor();
    }


}
