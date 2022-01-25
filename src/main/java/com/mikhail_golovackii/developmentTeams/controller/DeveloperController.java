package com.mikhail_golovackii.developmentTeams.controller;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import java.util.List;

public interface DeveloperController extends BaseController<Developer> {

    public void deleteSkillFromDeveloper(int idDeveloper, List<Integer> idSkills);

    public void addSkillToDeveloper(int idDeveloper, List<Integer> idSkills);
}
