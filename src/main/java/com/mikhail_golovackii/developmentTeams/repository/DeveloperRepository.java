
package com.mikhail_golovackii.developmentTeams.repository;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import java.util.List;

public interface DeveloperRepository extends BaseRepository<Developer>{

    public void deleteSkillFromDeveloper(int idDeveloper, List<Integer> idSkills);
    
    public void addSkillToDeveloper(int idDeveloper, List<Integer> idSkills);
}
