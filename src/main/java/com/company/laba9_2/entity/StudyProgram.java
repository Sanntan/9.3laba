package com.company.laba9_2.entity;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import jakarta.persistence.*;

import java.util.List;

@JmixEntity
@Entity
@Table(name = "STUDY_PROGRAM")
public class StudyProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InstanceName
    @DependsOnProperties("name")
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "studyProgram")
    private List<ElectiveCourse> electiveCourses;

    @OneToMany(mappedBy = "studyProgram")
    private List<Student> students;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<ElectiveCourse> getElectiveCourses() { return electiveCourses; }
    public void setElectiveCourses(List<ElectiveCourse> electiveCourses) { this.electiveCourses = electiveCourses; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
