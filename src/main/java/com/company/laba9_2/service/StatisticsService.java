package com.company.laba9_2.service;

import com.company.laba9_2.entity.Student;
import com.company.laba9_2.entity.ElectiveCourse;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;
import java.util.OptionalDouble;

@Service
public class StatisticsService {
    @Autowired
    private DataManager dataManager;

    public long countStudentsJpql() {
        return dataManager.loadValue("select count(s) from Student s", Long.class).one();
    }

    public double averageHoursManual() {
        List<ElectiveCourse> courses = dataManager.load(ElectiveCourse.class).all().list();
        OptionalDouble avg = courses.stream().mapToInt(ElectiveCourse::getHours).average();
        return avg.orElse(0.0);
    }

    @Nullable
    public Student getStudentById(Long id) {
        return dataManager.load(Student.class).id(id).optional().orElse(null);
    }

    public List<Student> findStudentsByLastName(String lastName) {
        return dataManager.load(Student.class)
                .query("select s from Student s where s.fullName like concat('%', :lastName, '%')")
                .parameter("lastName", lastName)
                .list();
    }
}
