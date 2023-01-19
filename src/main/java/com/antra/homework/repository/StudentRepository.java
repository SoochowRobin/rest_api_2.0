package com.antra.homework.repository;


import com.antra.homework.pojo.Student;
import com.antra.homework.pojo.dto.StudentDTO;

import java.util.List;

public interface StudentRepository {

    List<StudentDTO> getAll();

    StudentDTO getById(int id);

    void create(Student student);

    void deleteById(int id);

    void update(Student student);

}
