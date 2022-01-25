package com.mikhail_golovackii.developmentTeams.view.impl;

import com.mikhail_golovackii.developmentTeams.entity.Team;
import com.mikhail_golovackii.developmentTeams.view.TeamView;
import java.util.List;

public class TeamViewImpl implements TeamView {

    @Override
    public void saveEntity() {
        System.out.println("Team is saved");
    }

    @Override
    public void updateEntity() {
        System.out.println("Team is updated");
    }

    @Override
    public void showEntityById(Team elem) {
        System.out.println(elem);
    }

    @Override
    public void showAllEntities(List<Team> elem) {
        elem.forEach(System.out::println);
    }

    @Override
    public void deleteEntity() {
        System.out.println("Team is deleted");
    }

    @Override
    public void deleteDeveloperFromTeam() {
        System.out.println("Delete developer from team");
    }

    @Override
    public void addDeveloperToTeam() {
        System.out.println("Add developer to team");
    }

}
