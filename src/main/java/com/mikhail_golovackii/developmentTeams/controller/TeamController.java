
package com.mikhail_golovackii.developmentTeams.controller;

import com.mikhail_golovackii.developmentTeams.entity.Team;
import java.util.List;

public interface TeamController extends BaseController<Team>{

    public void deleteDeveloperFromTeam(int idTeam, List<Integer> idDevelopers);

    public void addDeveloperToTeam(int idTeam, List<Integer> idDevelopers);

}
