package com.mikhail_golovackii.developmentTeams.repository.impl;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.entity.Team;
import com.mikhail_golovackii.developmentTeams.repository.DeveloperRepository;
import com.mikhail_golovackii.developmentTeams.repository.TeamRepository;
import com.mikhail_golovackii.developmentTeams.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TeamRepositoryImpl implements TeamRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private DeveloperRepository developerRepository = null;
    private Session session;

    @Override
    public void save(Team elem) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(elem);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateById(int id, Team elem) {
        Team team = getById(id);
        
        if (team == null) {
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
    public Team getById(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Team team = session.get(Team.class, id);
        session.getTransaction().commit();
        session.close();

        return team;
    }

    @Override
    public List<Team> getAll() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Team> teams = session.createQuery("FROM Team").getResultList();
        session.getTransaction().commit();
        session.close();

        return teams;
    }

    @Override
    public void deleteById(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Team team = session.get(Team.class, id);

        if (team != null) {
            session.delete(team);
        }
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteDeveloperFromTeam(int idTeam, List<Integer> idDevelopers) {
        Team team = getById(idTeam);
        List<Developer> developers = new ArrayList<>();
        developerRepository = new DeveloperRepositoryImpl();

        if (team == null) {
            return;
        }

        for (Integer idDeveloper : idDevelopers) {
            Developer developer = developerRepository.getById(idDeveloper);

            if (developer == null) {
                continue;
            }

            developers.add(developer);
        }

        if (!developers.isEmpty()) {
            team.removeDevelopers(developers);
            updateById(idTeam, team);
        }
    }

    @Override
    public void addDeveloperToTeam(int idTeam, List<Integer> idDevelopers) {
        Team team = getById(idTeam);
        List<Developer> developers = new ArrayList<>();
        developerRepository = new DeveloperRepositoryImpl();

        if (team == null) {
            return;
        }

        for (Integer idDeveloper : idDevelopers) {
            Developer developer = developerRepository.getById(idDeveloper);

            if (developer == null) {
                continue;
            }

            developers.add(developer);
        }
        
        if (!developers.isEmpty()) {
            team.addDevelopers(developers);
            updateById(idTeam, team);
        }
    }

}
