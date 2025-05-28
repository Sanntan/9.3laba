package com.company.laba9_2.view.student;

import com.company.laba9_2.entity.ElectiveCourse;
import com.company.laba9_2.entity.Student;
import com.company.laba9_2.entity.StudyProgram;
import com.company.laba9_2.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.exception.ValidationException;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.view.*;

import java.util.List;
import java.util.stream.Collectors;

@Route(value = "students/:id", layout = MainView.class)
@ViewController("Student.detail")
@ViewDescriptor("student-detail-view.xml")
@EditedEntityContainer("studentDc")
public class StudentDetailView extends StandardDetailView<Student> {

    @ViewComponent
    private InstanceContainer<Student> studentDc;

    private boolean warningAlreadyShown = false;

    @Subscribe
    public void onBeforeSave(BeforeSaveEvent event) {
        Student student = studentDc.getItem();
        StudyProgram studyProgram = student.getStudyProgram();

        if (studyProgram != null && student.getElectiveCourses() != null) {
            List<ElectiveCourse> invalidCourses = student.getElectiveCourses().stream()
                    .filter(course -> !studyProgram.equals(course.getStudyProgram()))
                    .collect(Collectors.toList());

            if (!invalidCourses.isEmpty()) {
                // silently fix
                List<ElectiveCourse> validCourses = student.getElectiveCourses().stream()
                        .filter(course -> studyProgram.equals(course.getStudyProgram()))
                        .collect(Collectors.toList());

                student.setElectiveCourses(validCourses);

                if (!warningAlreadyShown) {
                    showValidationErrors("Удалены элективные курсы, не относящиеся к направлению.");
                    warningAlreadyShown = true;
                }
            }
        }
    }

    private void showValidationErrors(String message) {
        throw new ValidationException(message);
    }
}
