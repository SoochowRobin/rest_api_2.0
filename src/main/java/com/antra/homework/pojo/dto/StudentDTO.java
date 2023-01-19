package com.antra.homework.pojo.dto;

import com.antra.homework.pojo.Student;
import lombok.Data;

@Data
public class StudentDTO {

    private String firstname;
    private String lastname;
    private Double gpa;

    public StudentDTO(Student s){
        this.firstname = s.getFirstname();
        this.lastname = s.getLastname();
        this.gpa = s.getGpa();
    }


}
