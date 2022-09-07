package com.company.jmixpm.screen.project;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@UiController("Project.browse")
@UiDescriptor("project-browse.xml")
@LookupComponent("projectsTable")
public class ProjectBrowse extends StandardLookup<Project> {

    @Autowired
    private DataManager dataManager;
    @Autowired
    private CurrentAuthentication currentAuthentication;

    /*@Subscribe("generateDataBtn")
    public void onGenerateDataBtnClick(Button.ClickEvent event) {
        List<Project> result = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            Project project = dataManager.create(Project.class);
            project.setManager((User) currentAuthentication.getUser());
            project.setName("Generated №" + i);
            result.add(project);
        }

        dataManager.save(result.toArray());

        getScreenData().loadAll();
    }*/


}