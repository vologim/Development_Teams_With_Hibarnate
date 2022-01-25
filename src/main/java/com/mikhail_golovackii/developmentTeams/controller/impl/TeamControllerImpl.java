
package com.mikhail_golovackii.developmentTeams.controller.impl;

import com.mikhail_golovackii.developmentTeams.controller.TeamController;
import com.mikhail_golovackii.developmentTeams.entity.Team;
import com.mikhail_golovackii.developmentTeams.service.TeamService;
import com.mikhail_golovackii.developmentTeams.service.impl.TeamServiceImpl;
import com.mikhail_golovackii.developmentTeams.view.TeamView;
import com.mikhail_golovackii.developmentTeams.view.impl.TeamViewImpl;
import java.util.List;


public class TeamControllerImpl implements TeamController{

    private final TeamService service = new TeamServiceImpl();
    private final TeamView view = new TeamViewImpl();
    
    @Override
    public void save(Team elem) {
        service.save(elem);
        view.saveEntity();
    }

    @Override
    public void updateById(int id, Team elem) {
        service.updateById(id, elem);
        view.updateEntity();
    }

    @Override
    public void getById(int id) {
        Team team = service.getById(id);
        view.showEntityById(team);
    }

    @Override
    public void getAll() {
        List<Team> teams = service.getAll();
        view.showAllEntities(teams);
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
        view.deleteEntity();
    }

    @Override
    public void deleteDeveloperFromTeam(int idTeam, List<Integer> idDevelopers) {
        service.deleteDeveloperFromTeam(idTeam, idDevelopers);
        view.deleteDeveloperFromTeam();
    }

    @Override
    public void addDeveloperToTeam(int idTeam, List<Integer> idDevelopers) {
        service.addDeveloperToTeam(idTeam, idDevelopers);
        view.addDeveloperToTeam();
    }

}
