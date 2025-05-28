package com.company.laba9_2.view.studyprogram;

import com.company.laba9_2.entity.StudyProgram;
import com.company.laba9_2.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "study-programs/:id", layout = MainView.class)
@ViewController(id = "StudyProgram.detail")
@ViewDescriptor(path = "study-program-detail-view.xml")
@EditedEntityContainer("studyProgramDc")
public class StudyProgramDetailView extends StandardDetailView<StudyProgram> {
}