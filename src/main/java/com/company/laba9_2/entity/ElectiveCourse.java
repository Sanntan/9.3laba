package com.company.laba9_2.entity;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import jakarta.persistence.*;

import java.util.List;

@JmixEntity
@Entity
@Table(name = "ELECTIVE_COURSE")
public class ElectiveCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InstanceName
    @DependsOnProperties("name")
    @Column(name = "NAME")
    private String name;

    @Column(name = "HOURS")
    private Integer hours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDY_PROGRAM_ID")
    private StudyProgram studyProgram;

    @ManyToMany(mappedBy = "electiveCourses")
    private List<Student> students;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getHours() { return hours; }
    public void setHours(Integer hours) { this.hours = hours; }

    public StudyProgram getStudyProgram() { return studyProgram; }
    public void setStudyProgram(StudyProgram studyProgram) { this.studyProgram = studyProgram; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
