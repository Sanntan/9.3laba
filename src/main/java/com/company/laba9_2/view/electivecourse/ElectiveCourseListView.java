package com.company.laba9_2.view.electivecourse;

import com.company.laba9_2.entity.ElectiveCourse;
import com.company.laba9_2.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "elective-courses", layout = MainView.class)
@ViewController(id = "ElectiveCourse.list")
@ViewDescriptor(path = "elective-course-list-view.xml")
@LookupComponent("electiveCoursesDataGrid")
@DialogMode(width = "64em")
public class ElectiveCourseListView extends StandardListView<ElectiveCourse> {
}