package com.antra.homework.repository.impl;

import com.antra.homework.pojo.Course;
import com.antra.homework.pojo.dto.CourseDTO;
import com.antra.homework.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // could not autowire, bean not found

//    private EntityManager entityManager;
//    @Autowired
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public List<CourseDTO> getAll() {
        List<Course> courseList =   (List<Course>)entityManager.createQuery("select c from Course c").getResultList();
        return courseList.stream()
                .map(x -> new CourseDTO(x))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getById(int id) {
        Query query = entityManager.createQuery("select c from Course c where c.id = ?1");
        query.setParameter(1, String.valueOf(id));
        // 这边如果没有查到用户，怎么处理异常信息？ 在service 层 try catch???
        Course course = (Course) query.getSingleResult();
        return new CourseDTO(course);
    }

    @Override
    public void create(Course course) {
        entityManager.persist(course);
    }

    @Override
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("select c from Course c where c.id = ?1");
        query.setParameter(1, String.valueOf(id));
        Course course = (Course)query.getSingleResult();
        entityManager.remove(course);
    }
}
