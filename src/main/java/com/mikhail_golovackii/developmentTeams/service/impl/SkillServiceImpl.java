
package com.mikhail_golovackii.developmentTeams.service.impl;

import com.mikhail_golovackii.developmentTeams.entity.Skill;
import com.mikhail_golovackii.developmentTeams.repository.SkillRepository;
import com.mikhail_golovackii.developmentTeams.repository.impl.SkillRepositoryImpl;
import com.mikhail_golovackii.developmentTeams.service.SkillService;
import java.util.List;

public class SkillServiceImpl implements SkillService{

    private SkillRepository repository;

    public SkillServiceImpl() {
        this.repository = new SkillRepositoryImpl();
    }

    public SkillServiceImpl(SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Skill elem) {
        repository.save(elem);
    }

    @Override
    public void updateById(int id, Skill elem) {
        repository.updateById(id, elem);
    }

    @Override
    public Skill getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Skill> getAll() {
        return repository.getAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
