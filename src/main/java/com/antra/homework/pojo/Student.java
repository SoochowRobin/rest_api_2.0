package com.antra.homework.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * use lombox to generate getter setter etc, use @Table, @Entity to map pojo to db
 */

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "grade")
    private String grade;

    @Column(name = "gpa")
    private Double gpa;

    @Column(name = "address")
    private String address;


    // mappedby is filed in joint class, instead of column name
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Student_Course> student_course;

    /*
    getter and setter for student_course. lombox will generate?
     */
    public Set<Student_Course> getStudent_course() {
        return student_course;
    }

    public void setStudent_course(Set<Student_Course> student_course) {
        this.student_course = student_course;
    }

}
