
package com.mikhail_golovackii.developmentTeams.service.impl;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.entity.Team;
import com.mikhail_golovackii.developmentTeams.repository.impl.TeamRepositoryImpl;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

public class TeamServiceImplTest {
    
    @Mock
    private TeamRepositoryImpl repository;
    
    @InjectMocks
    private TeamServiceImpl service = new TeamServiceImpl(repository);
    
    @Before
    public void initBefore() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        service.save(Mockito.any());
        
        verify(repository).save(Mockito.any());
    }

    @Test
    public void testUpdateById() {
        service.updateById(getTeam());

        verify(repository).updateById(getTeam());
    }

    @Test
    public void testGetById() {
        Mockito.when(repository.getById(1)).thenReturn(getTeam());
        
        Team testTeam = service.getById(1);
        
        assertEquals(getTeam(), testTeam);
        assertEquals(1, testTeam.getId());
    }

    @Test
    public void testGetAll() {
        Mockito.when(repository.getAll()).thenReturn(getTeams());
        
        List<Team> testTeams = service.getAll();

        assertEquals(getTeams().size(), testTeams.size());
        assertEquals(getTeams().get(1), testTeams.get(1));
    }

    @Test
    public void testDeleteById() {
        service.deleteById(1);

        verify(repository).deleteById(1);
    }

    @Test
    public void testDeleteDeveloperFromTeam() {
        List<Integer> idDevelopers = List.of(1, 2);
        
        Mockito.doNothing().when(repository).deleteDeveloperFromTeam(1, idDevelopers);
        
        service.deleteDeveloperFromTeam(1, idDevelopers);
        
        verify(repository).deleteDeveloperFromTeam(1, idDevelopers);
    }

    @Test
    public void testAddDeveloperToTeam() {
        List<Integer> idDevelopers = List.of(1, 2);
        
        Mockito.doNothing().when(repository).addDeveloperToTeam(3, idDevelopers);
        
        service.addDeveloperToTeam(3, idDevelopers);

        verify(repository).addDeveloperToTeam(3, idDevelopers);
    }
    
    private List<Developer> getDevelopers() {
        return List.of(new Developer("Name 1", "Last Name 1"),
                       new Developer("Name 2", "Last Name 2"),
                       new Developer("Name 3", "Last Name 3"));
    }
    
    private List<Team> getTeams() {
        return List.of(new Team("Name 1"),
                       new Team("Name 2"),
                       new Team("Name 3"));
    }
    
    private Team getTeam() {
        Team team = new Team("Team 1");
        team.setDevelopers(getDevelopers());
        team.setId(1);
        return team;
    }
}
