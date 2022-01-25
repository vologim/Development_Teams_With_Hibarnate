
package com.mikhail_golovackii.developmentTeams.view.impl;

import com.mikhail_golovackii.developmentTeams.entity.Skill;
import com.mikhail_golovackii.developmentTeams.view.SkillView;
import java.util.List;

public class SkillViewImpl implements SkillView{

    @Override
    public void saveEntity() {
        System.out.println("Skill is saved");
    }

    @Override
    public void updateEntity() {
        System.out.println("Skill is updated");
    }

    @Override
    public void showEntityById(Skill elem) {
        System.out.println(elem);
    }

    @Override
    public void showAllEntities(List<Skill> elem) {
        elem.forEach(System.out::println);
    }

    @Override
    public void deleteEntity() {
        System.out.println("Skill is deleted");
    }
}
