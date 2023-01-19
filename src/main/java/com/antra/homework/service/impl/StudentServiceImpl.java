package com.antra.homework.service.impl;

import com.antra.homework.pojo.Student;
import com.antra.homework.pojo.dto.StudentDTO;
import com.antra.homework.repository.StudentRepository;
import com.antra.homework.repository.impl.StudentRepositoryImpl;
import com.antra.homework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepositoryImpl studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDTO> get() {
        return studentRepository.getAll();
    }

    @Override
    public StudentDTO getById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    @Transactional
    public void save(Student student) {

        studentRepository.create(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Student student) {
        studentRepository.update(student);
    }
}
