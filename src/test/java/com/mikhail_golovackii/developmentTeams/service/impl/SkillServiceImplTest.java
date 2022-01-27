
package com.mikhail_golovackii.developmentTeams.service.impl;

import com.mikhail_golovackii.developmentTeams.entity.Skill;
import com.mikhail_golovackii.developmentTeams.repository.impl.SkillRepositoryImpl;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

public class SkillServiceImplTest {
    
    @Mock
    private SkillRepositoryImpl repository;
    
    @InjectMocks
    private SkillServiceImpl service;

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
        service.updateById(1, getSkill());
        
        verify(repository).updateById(1, getSkill());
    }

    @Test
    public void testGetById() {
        Mockito.when(repository.getById(1)).thenReturn(getSkill());
    
        Skill testSkill = service.getById(1);
        
        assertEquals(getSkill(), testSkill);
        assertEquals(1, testSkill.getId());
    }

    @Test
    public void testGetAll() {
        Mockito.when(repository.getAll()).thenReturn(getSkills());
        
        List<Skill> testSkills = service.getAll();

        assertEquals(getSkills().size(), testSkills.size());
        assertEquals(getSkills().get(1), testSkills.get(1));
    }

    @Test
    public void testDeleteById() {
        service.deleteById(1);
        
        verify(repository).deleteById(1);
    }
    
    private Skill getSkill() {
        Skill skill = new Skill("Test 1");
        skill.setId(1);
        return skill;
    }
    
    private List<Skill> getSkills() {
        return List.of(new Skill("Test 1"),
                       new Skill("Test 2"),
                       new Skill("Test 3"));
    }
}
