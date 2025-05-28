package com.company.laba9_2.view.studyprogram;

import com.company.laba9_2.entity.StudyProgram;
import com.company.laba9_2.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "study-programs", layout = MainView.class)
@ViewController(id = "StudyProgram.list")
@ViewDescriptor(path = "study-program-list-view.xml")
@LookupComponent("studyProgramsDataGrid")
@DialogMode(width = "64em")
public class StudyProgramListView extends StandardListView<StudyProgram> {
}