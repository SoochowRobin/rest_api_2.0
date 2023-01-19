package com.antra.homework.service;

import com.antra.homework.pojo.Student;
import com.antra.homework.pojo.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> get();

    StudentDTO getById(int id);

    void save(Student student);

    void deleteById(int id);

    void update(Student student);

}
