package com.antra.homework.pojo.dto;

import com.antra.homework.pojo.Student_Course;
import lombok.Data;

@Data
public class Student_CourseDTO {

    private Double score;

    public Student_CourseDTO(Student_Course sc){
        this.score = sc.getScore();
    }
}
