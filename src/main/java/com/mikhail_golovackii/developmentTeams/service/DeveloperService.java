package com.mikhail_golovackii.developmentTeams.service;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import java.util.List;

public interface DeveloperService extends BaseService<Developer> {

    public void deleteSkillFromDeveloper(int idDeveloper, List<Integer> idSkills);

    public void addSkillToDeveloper(int idDeveloper, List<Integer> idSkills);
}
