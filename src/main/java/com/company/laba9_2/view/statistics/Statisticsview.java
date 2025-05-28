package com.company.laba9_2.view.statistics;

import com.company.laba9_2.entity.Student;
import com.company.laba9_2.service.StatisticsService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.company.laba9_2.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.Notifications;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "StatisticsView", layout = MainView.class)
@ViewController("Statisticsview")
@ViewDescriptor("StatisticsView.xml")
public class Statisticsview extends StandardView {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private Notifications notifications;

    @ViewComponent
    private TextField studentIdField;

    @ViewComponent
    private TextField lastNameField;

    @Subscribe("btnCountStudents")
    public void onCountStudentsClick(ClickEvent<Button> event) {
        long count = statisticsService.countStudentsJpql();
        notifications.create("Количество студентов: " + count).show();
    }

    @Subscribe("btnAverageHours")
    public void onAverageHoursClick(ClickEvent<Button> event) {
        double avg = statisticsService.averageHoursManual();
        notifications.create("Среднее количество часов: " + avg).show();
    }

    @Subscribe("btnFindStudentById")
    public void onFindStudentByIdClick(ClickEvent<Button> event) {
        try {
            Long id = Long.parseLong(studentIdField.getValue());
            Student student = statisticsService.getStudentById(id);
            if (student != null) {
                notifications.create("Найден студент: " + student.getFullName()).show();
            } else {
                notifications.create("Студент не найден").show();
            }
        } catch (NumberFormatException e) {
            notifications.create("Неверный формат ID (нужно число)").show();
        }
    }

    @Subscribe("btnFindByLastName")
    public void onFindByLastNameClick(ClickEvent<Button> event) {
        String lastName = lastNameField.getValue();
        List<Student> students = statisticsService.findStudentsByLastName(lastName);
        notifications.create("Найдено студентов: " + students.size()).show();
    }
}
