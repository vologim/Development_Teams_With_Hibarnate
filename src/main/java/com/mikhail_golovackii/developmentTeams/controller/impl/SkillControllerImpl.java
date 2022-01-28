
package com.mikhail_golovackii.developmentTeams.controller.impl;

import com.mikhail_golovackii.developmentTeams.controller.SkillController;
import com.mikhail_golovackii.developmentTeams.entity.Skill;
import com.mikhail_golovackii.developmentTeams.service.SkillService;
import com.mikhail_golovackii.developmentTeams.service.impl.SkillServiceImpl;
import com.mikhail_golovackii.developmentTeams.view.SkillView;
import com.mikhail_golovackii.developmentTeams.view.impl.SkillViewImpl;
import java.util.List;


public class SkillControllerImpl implements SkillController{

    private final SkillService service = new SkillServiceImpl();
    private final SkillView view = new SkillViewImpl();
    
    @Override
    public void save(Skill elem) {
        service.save(elem);
        view.saveEntity();
    }

    @Override
    public void updateById(Skill elem) {
        service.updateById(elem);
        view.updateEntity();
    }

    @Override
    public void getById(int id) {
        Skill skill = service.getById(id);
        view.showEntityById(skill);
    }

    @Override
    public void getAll() {
        List<Skill> skills = service.getAll();
        view.showAllEntities(skills);
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
        view.deleteEntity();
    }

}
