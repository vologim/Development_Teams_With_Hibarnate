package com.mikhail_golovackii.developmentTeams.service.impl;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.repository.impl.DeveloperRepositoryImpl;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

public class DeveloperServiceImplTest {

    @Mock
    private DeveloperRepositoryImpl repository;

    @InjectMocks
    private DeveloperServiceImpl service;

    @Before
    public void initBefore() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        service.save(new Developer("Test 1", "Test 1"));

        verify(repository).save(new Developer("Test 1", "Test 1"));
    }

    @Test
    public void testUpdateById() {
        Developer developer = new Developer("Test 1", "Test 1");
        developer.setId(10);

        service.updateById(10, developer);

        verify(repository).updateById(10, developer);
    }

    @Test
    public void testGetById() {
        Developer developer = getDevelopers().get(1);
        developer.setId(1);
        Mockito.when(repository.getById(1)).thenReturn(developer);

        Developer testDeveloper = service.getById(1);

        assertEquals(developer, testDeveloper);
        assertEquals(1, testDeveloper.getId());
        assertNotNull(testDeveloper);
    }

    @Test
    public void testGetAll() {
        Mockito.when(repository.getAll()).thenReturn(getDevelopers());

        List<Developer> developers = service.getAll();

        assertEquals(getDevelopers().size(), developers.size());
        assertEquals(getDevelopers().get(1), developers.get(1));
    }

    @Test
    public void testDeleteById() {
        service.deleteById(1);

        verify(repository).deleteById(1);
    }

    @Test
    public void testDeleteSkillFromDeveloper() {
        List<Integer> idSkills = List.of(1, 2);
        service.deleteSkillFromDeveloper(1, idSkills);

        verify(repository).deleteSkillFromDeveloper(1, idSkills);
    }

    @Test
    public void testAddSkillToDeveloper() {
        List<Integer> idSkills = List.of(1, 2);
        service.addSkillToDeveloper(3, idSkills);

        verify(repository).addSkillToDeveloper(3, idSkills);
    }

//    @Test
//    public void testAddTeamToDeveloper() {
//        List<Integer> idTeam = List.of(1, 2);
//        service.addSkillToDeveloper(3, idTeam);
//
//        verify(repository).addTeamToDeveloper(3, idTeam);
//    }
//
//    @Test
//    public void testDeleteTeamToDeveloper() {
//        List<Integer> idTeam = List.of(1, 2);
//        service.addSkillToDeveloper(3, idTeam);
//
//        verify(repository).deleteTeamToDeveloper(3, idTeam);
//    }

    private List<Developer> getDevelopers() {
        return List.of(new Developer("Name 1", "Last Name 1"),
                new Developer("Name 2", "Last Name 2"),
                new Developer("Name 3", "Last Name 3"));
    }
}
