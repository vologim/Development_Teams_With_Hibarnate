
package com.mikhail_golovackii.developmentTeams.repository;

import com.mikhail_golovackii.developmentTeams.entity.Team;
import java.util.List;

public interface TeamRepository extends BaseRepository<Team>{

    public void deleteDeveloperFromTeam(int idTeam, List<Integer> idDevelopers);

    public void addDeveloperToTeam(int idTeam, List<Integer> idDevelopers);

}
