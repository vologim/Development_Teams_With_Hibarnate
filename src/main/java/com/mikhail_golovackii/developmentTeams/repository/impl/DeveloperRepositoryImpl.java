package com.mikhail_golovackii.developmentTeams.repository.impl;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.entity.Skill;
import com.mikhail_golovackii.developmentTeams.repository.DeveloperRepository;
import com.mikhail_golovackii.developmentTeams.repository.SkillRepository;
import com.mikhail_golovackii.developmentTeams.repository.TeamRepository;
import com.mikhail_golovackii.developmentTeams.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private SkillRepository skillRepository = null;
    private TeamRepository teamRepository = null;
    private Session session;

    @Override
    public void save(Developer elem) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(elem);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateById(int id, Developer elem) {
        Developer developer = getById(id);

        if (developer == null) {
            return;
        }

        elem.setId(id);

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(elem);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Developer getById(int id) {
        Developer developer;

        session = sessionFactory.openSession();
        session.beginTransaction();
        developer = session.get(Developer.class, id);
        session.getTransaction().commit();
        session.close();

        return developer;
    }

    @Override
    public List<Developer> getAll() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Developer> developers = session.createQuery("FROM Developer").getResultList();        
        session.getTransaction().commit();
        session.close();

        return developers;
    }

    @Override
    public void deleteById(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Developer developer = session.get(Developer.class, id);

        if (developer != null) {
            session.delete(developer);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteSkillFromDeveloper(int idDeveloper, List<Integer> idSkills) {
        Developer developer = getById(idDeveloper);
        List<Skill> skills = new ArrayList<>();
        skillRepository = new SkillRepositoryImpl();

        if (developer == null) {
            return;
        }

        for (Integer idSkill : idSkills) {
            Skill skill = skillRepository.getById(idSkill);

            if (skill == null) {
                continue;
            }
            skills.add(skill);
        }

        if (!skills.isEmpty()) {
            developer.removeSkill(skills);
            updateById(idDeveloper, developer);
        }
    }

    @Override
    public void addSkillToDeveloper(int idDeveloper, List<Integer> idSkills) {
        Developer developer = getById(idDeveloper);
        List<Skill> skills = new ArrayList<>();
        skillRepository = new SkillRepositoryImpl();

        if (developer == null) {
            return;
        }

        for (Integer idSkill : idSkills) {
            Skill skill = skillRepository.getById(idSkill);

            if (skill == null) {
                continue;
            }
            skills.add(skill);
        }

        if (!skills.isEmpty()) {
            developer.addSkill(skills);
            updateById(idDeveloper, developer);
        }
    }
}
