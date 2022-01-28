package com.mikhail_golovackii.developmentTeams.service.impl;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.entity.Skill;
import com.mikhail_golovackii.developmentTeams.repository.impl.DeveloperRepositoryImpl;
import java.util.ArrayList;
import java.util.Collections;
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
    private DeveloperServiceImpl service = new DeveloperServiceImpl(repository);

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
        service.updateById(getDeveloper());

        verify(repository).updateById(getDeveloper());
    }

    @Test
    public void testGetById() {
        Mockito.when(repository.getById(1)).thenReturn(getDeveloper());

        Developer testDeveloper = service.getById(1);

        assertEquals(getDeveloper(), testDeveloper);
        assertEquals(1, testDeveloper.getId());
    }

    @Test
    public void testGetAll() {
        Mockito.when(repository.getAll()).thenReturn(getDevelopers());
        
        List<Developer> testDevelopers = service.getAll();

        assertEquals(getDevelopers().size(), testDevelopers.size());
        assertEquals(getDevelopers().get(1), testDevelopers.get(1));
    }

    @Test
    public void testDeleteById() {
        service.deleteById(1);

        verify(repository).deleteById(1);
    }

    @Test
    public void testDeleteSkillFromDeveloper() {
        List<Integer> idSkills = List.of(1, 2);
        
        Mockito.doNothing().when(repository).deleteSkillFromDeveloper(1, idSkills);
        
        service.deleteSkillFromDeveloper(1, idSkills);
        
        verify(repository).deleteSkillFromDeveloper(1, idSkills);
    }

    @Test
    public void testAddSkillToDeveloper() {
        List<Integer> idSkills = List.of(1, 2);
        
        Mockito.doNothing().when(repository).addSkillToDeveloper(3, idSkills);
        
        service.addSkillToDeveloper(3, idSkills);

        verify(repository).addSkillToDeveloper(3, idSkills);
    }

    private List<Skill> getSkills() {
        List<Skill> skills = new ArrayList<>();
        
        Skill sk1 = new Skill("Skill 1");
        Skill sk2 = new Skill("Skill 2");
        Skill sk3 = new Skill("Skill 3");
        
        sk1.setId(1);
        sk2.setId(2);
        sk3.setId(3);
        
        Collections.addAll(skills, sk1, sk2, sk3);
        
        return skills;
    }
    
    private List<Developer> getDevelopers() {
        return List.of(new Developer("Name 1", "Last Name 1"),
                       new Developer("Name 2", "Last Name 2"),
                       new Developer("Name 3", "Last Name 3"));
    }
    
    private Developer getDeveloper() {
        Developer developer = new Developer("Test 1", "Test 2");
        developer.setId(1);
        developer.setSkills(getSkills());
        return developer;
    }
}
