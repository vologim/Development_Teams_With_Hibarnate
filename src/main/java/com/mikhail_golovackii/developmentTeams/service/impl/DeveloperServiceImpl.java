
package com.mikhail_golovackii.developmentTeams.service.impl;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.repository.DeveloperRepository;
import com.mikhail_golovackii.developmentTeams.repository.impl.DeveloperRepositoryImpl;
import com.mikhail_golovackii.developmentTeams.service.DeveloperService;
import java.util.List;

public class DeveloperServiceImpl implements DeveloperService{

    private DeveloperRepository repository;

    public DeveloperServiceImpl() {
        this.repository = new DeveloperRepositoryImpl();
    }

    public DeveloperServiceImpl(DeveloperRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Developer elem) {
        repository.save(elem);
    }

    @Override
    public void updateById(Developer elem) {
        repository.updateById(elem);
    }

    @Override
    public Developer getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Developer> getAll() {
        return repository.getAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteSkillFromDeveloper(int idDeveloper, List<Integer> idSkills) {
        repository.deleteSkillFromDeveloper(idDeveloper, idSkills);
    }

    @Override
    public void addSkillToDeveloper(int idDeveloper, List<Integer> idSkills) {
        repository.addSkillToDeveloper(idDeveloper, idSkills);
    }
}
