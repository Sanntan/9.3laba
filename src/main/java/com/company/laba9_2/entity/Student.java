package com.company.laba9_2.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@JmixEntity
@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InstanceName
    @DependsOnProperties("fullName")
    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "STUDENT_CARD_NUMBER")
    private String studentCardNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDY_PROGRAM_ID")
    private StudyProgram studyProgram;

    @ManyToMany
    @JoinTable(name = "STUDENT_ELECTIVE_COURSE_LINK",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ELECTIVE_COURSE_ID"))
    private List<ElectiveCourse> electiveCourses;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getStudentCardNumber() { return studentCardNumber; }
    public void setStudentCardNumber(String studentCardNumber) { this.studentCardNumber = studentCardNumber; }

    public StudyProgram getStudyProgram() { return studyProgram; }
    public void setStudyProgram(StudyProgram studyProgram) { this.studyProgram = studyProgram; }

    public List<ElectiveCourse> getElectiveCourses() { return electiveCourses; }
    public void setElectiveCourses(List<ElectiveCourse> electiveCourses) { this.electiveCourses = electiveCourses; }
}
