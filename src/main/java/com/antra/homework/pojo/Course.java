package com.antra.homework.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "instructor")
    private String instructor;
    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Student_Course> student_course;


    /**
     *getter and setter for student_course
     */
    public Set<Student_Course> getStudent_course() {
        return student_course;
    }

    public void setStudent_course(Set<Student_Course> student_course) {
        this.student_course = student_course;
    }
}
