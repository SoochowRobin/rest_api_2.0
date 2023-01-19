package com.antra.homework.repository.impl;

import com.antra.homework.pojo.Student;
import com.antra.homework.pojo.dto.StudentDTO;
import com.antra.homework.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    /*
     why could not use @Autowired to get entityManager ?
     */

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public List<StudentDTO> getAll() {
        List<Student> studentList = entityManager.createQuery("select s from Student s").getResultList();
        return studentList.stream()
                .map(x -> new StudentDTO(x))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getById(int id) {

        Query nativeQuery = entityManager.createQuery("select s from Student s where s.id =?1");
        nativeQuery.setParameter(1, String.valueOf(id));
        Student s = (Student) nativeQuery.getSingleResult();
        return new StudentDTO(s);
    }

    @Override
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("select s from Student s where s.id =?1 ");
        query.setParameter(1, String.valueOf(id));
        Student singleResult =(Student)query.getSingleResult();
        // try catch
        entityManager.remove(singleResult);
    }

    @Override
    public void update(Student student) {
        /*
        it seems no need to search and merge it directly
         */

//        Query query = entityManager.createQuery("select s from Student s where s.id =?1 ");
//        query.setParameter(1, String.valueOf(student.getId()));
//        Student singleResult = (Student)query.getSingleResult();
//        singleResult = student;
        entityManager.merge(student);
    }
}
