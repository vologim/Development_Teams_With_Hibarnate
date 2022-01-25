
package com.mikhail_golovackii.developmentTeams.service;

import com.mikhail_golovackii.developmentTeams.entity.Team;
import java.util.List;

public interface TeamService extends BaseService<Team>{

    public void deleteDeveloperFromTeam(int idTeam, List<Integer> idDevelopers);

    public void addDeveloperToTeam(int idTeam, List<Integer> idDevelopers);

}
