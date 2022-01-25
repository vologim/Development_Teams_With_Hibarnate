
package com.mikhail_golovackii.developmentTeams.view;

import com.mikhail_golovackii.developmentTeams.entity.Team;

public interface TeamView extends BaseView<Team>{

    public void deleteDeveloperFromTeam();

    public void addDeveloperToTeam();

}
