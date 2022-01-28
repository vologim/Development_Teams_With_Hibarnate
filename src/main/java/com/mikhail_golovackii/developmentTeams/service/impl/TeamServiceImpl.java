
package com.mikhail_golovackii.developmentTeams.service.impl;

import com.mikhail_golovackii.developmentTeams.entity.Team;
import com.mikhail_golovackii.developmentTeams.repository.TeamRepository;
import com.mikhail_golovackii.developmentTeams.repository.impl.TeamRepositoryImpl;
import com.mikhail_golovackii.developmentTeams.service.TeamService;
import java.util.List;

public class TeamServiceImpl implements TeamService{

    private TeamRepository repository;

    public TeamServiceImpl() {
        this.repository = new TeamRepositoryImpl();
    }

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Team elem) {
        repository.save(elem);
    }

    @Override
    public void updateById(Team elem) {
        repository.updateById(elem);
    }

    @Override
    public Team getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Team> getAll() {
        return repository.getAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteDeveloperFromTeam(int idTeam, List<Integer> idDevelopers) {
        repository.deleteDeveloperFromTeam(idTeam, idDevelopers);
    }

    @Override
    public void addDeveloperToTeam(int idTeam, List<Integer> idDevelopers) {
        repository.addDeveloperToTeam(idTeam, idDevelopers);
    }

}
