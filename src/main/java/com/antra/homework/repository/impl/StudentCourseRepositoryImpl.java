package com.antra.homework.repository.impl;

import com.antra.homework.pojo.Course;
import com.antra.homework.pojo.Student;
import com.antra.homework.pojo.Student_Course;
import com.antra.homework.pojo.dto.Student_CourseDTO;
import com.antra.homework.repository.StudentCourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentCourseRepositoryImpl implements StudentCourseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student_CourseDTO getByStudentIdCourseId(int studentId, int courseId) {
        Query query = entityManager.createQuery("select sc from Student_Course sc where sc.student.id = ?1 and sc.course.id = ?2");
        query.setParameter(1, String.valueOf(studentId));
        query.setParameter(2, String.valueOf(courseId));

        Student_Course stuCourse = (Student_Course) query.getSingleResult();
        return new Student_CourseDTO(stuCourse);
    }

    @Override
    public void insert(Student_Course studentCourse) {


        // 这边设计有问题，一个int, 一个string

        /*
        Cannot invoke "com.antra.homework.pojo.Student.getId()"
        because the return value of "com.antra.homework.pojo.Student_Course.getStudent()" is null

        那要怎么插入数据？ 比如学生2， 科目3， 分数为80 呢？？

         */
        String stuId = studentCourse.getStudent().getId();
        int courseId = studentCourse.getCourse().getId();
        Student student = entityManager.find(Student.class, stuId);
        Course course = entityManager.find(Course.class, courseId);

        student.getStudent_course().add(studentCourse);
        course.getStudent_course().add(studentCourse);


        /*
        it will raise detached error when use persist
         */
        entityManager.merge(studentCourse);
    }

    /*
    既然insert 要查询出两个对象，进行add,那updade, delete 要对list, set 进行处理吗？？？
     */

    @Override
    public void deleteByStudentIdCourseId(int studentId, int courseId) {
        Query query = entityManager.createQuery("select sc from Student_Course sc where sc.student.id = ?1 and sc.course.id = ?2");
        query.setParameter(1, String.valueOf(studentId));
        query.setParameter(2, String.valueOf(courseId));
        // 这边要异常处理
        Student_Course stuCourse = (Student_Course) query.getSingleResult();
        entityManager.remove(stuCourse);
    }

    @Override
    public void update(Student_Course studentCourse) {
        entityManager.merge(studentCourse);
    }
}
