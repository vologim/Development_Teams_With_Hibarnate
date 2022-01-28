package com.mikhail_golovackii.developmentTeams.repository.impl;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.entity.Skill;
import com.mikhail_golovackii.developmentTeams.repository.DeveloperRepository;
import com.mikhail_golovackii.developmentTeams.repository.SkillRepository;
import com.mikhail_golovackii.developmentTeams.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private SkillRepository skillRepository = null;

    @Override
    public void save(Developer elem) {
        
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(elem);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void updateById(Developer elem) {
        Developer developer = getById(elem.getId());

        if (developer == null) {
            return;
        }

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(elem);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public Developer getById(int id) {

        try (Session session = sessionFactory.openSession()) {
            return (Developer) session.createQuery("FROM Developer d LEFT JOIN"
                    + " FETCH d.skills WHERE d.id = " + id).getSingleResult();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Developer> getAll() {
        
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Developer d LEFT JOIN"
                + " FETCH d.skills").getResultList();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void deleteById(int id) {
        
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Developer developer = session.get(Developer.class, id);

            if (developer != null) {
                session.delete(developer);
            }

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
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
            updateById(developer);
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
            updateById(developer);
        }
    }
}
