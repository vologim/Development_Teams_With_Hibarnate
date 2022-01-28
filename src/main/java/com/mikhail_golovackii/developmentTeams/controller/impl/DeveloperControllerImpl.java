
package com.mikhail_golovackii.developmentTeams.controller.impl;

import com.mikhail_golovackii.developmentTeams.controller.DeveloperController;
import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.service.DeveloperService;
import com.mikhail_golovackii.developmentTeams.service.impl.DeveloperServiceImpl;
import com.mikhail_golovackii.developmentTeams.view.DeveloperView;
import com.mikhail_golovackii.developmentTeams.view.impl.DeveloperViewImpl;
import java.util.List;


public class DeveloperControllerImpl implements DeveloperController{

    private final DeveloperService service = new DeveloperServiceImpl();
    private final DeveloperView view = new DeveloperViewImpl();
    
    @Override
    public void save(Developer elem) {
        service.save(elem);
        view.saveEntity();
    }

    @Override
    public void updateById(Developer elem) {
        service.updateById(elem);
        view.updateEntity();
    }

    @Override
    public void getById(int id) {
        Developer developer = service.getById(id);
        view.showEntityById(developer);
    }

    @Override
    public void getAll() {
        List<Developer> developers = service.getAll();
        view.showAllEntities(developers);
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
        view.deleteEntity();
    }

    @Override
    public void deleteSkillFromDeveloper(int idDeveloper, List<Integer> idSkills) {
        service.deleteSkillFromDeveloper(idDeveloper, idSkills);
        view.deleteSkillFromDeveloper();
    }

    @Override
    public void addSkillToDeveloper(int idDeveloper, List<Integer> idSkills) {
        service.addSkillToDeveloper(idDeveloper, idSkills);
        view.addSkillToDeveloper();
    }
}
