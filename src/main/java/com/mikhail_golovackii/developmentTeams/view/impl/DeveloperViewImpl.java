
package com.mikhail_golovackii.developmentTeams.view.impl;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.view.DeveloperView;
import java.util.List;

public class DeveloperViewImpl implements DeveloperView{

    @Override
    public void saveEntity() {
        System.out.println("Developer is saved");
    }

    @Override
    public void updateEntity() {
        System.out.println("Developer is updated");
    }

    @Override
    public void showEntityById(Developer elem) {
        System.out.println(elem);
    }

    @Override
    public void showAllEntities(List<Developer> elem) {
        elem.forEach(System.out::println);
    }

    @Override
    public void deleteEntity() {
        System.out.println("Developer is deleted");
    }

    @Override
    public void deleteSkillFromDeveloper() {
        System.out.println("Delete skill from developer");
    }

    @Override
    public void addSkillToDeveloper() {
        System.out.println("Add skill to developer");
    }
}
