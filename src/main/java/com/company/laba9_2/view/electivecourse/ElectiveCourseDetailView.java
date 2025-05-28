package com.company.laba9_2.view.electivecourse;

import com.company.laba9_2.entity.ElectiveCourse;
import com.company.laba9_2.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "elective-courses/:id", layout = MainView.class)
@ViewController(id = "ElectiveCourse.detail")
@ViewDescriptor(path = "elective-course-detail-view.xml")
@EditedEntityContainer("electiveCourseDc")
public class ElectiveCourseDetailView extends StandardDetailView<ElectiveCourse> {
}