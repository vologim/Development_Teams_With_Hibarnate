package com.mikhail_golovackii.developmentTeams.repository.impl;

import com.mikhail_golovackii.developmentTeams.entity.Skill;
import com.mikhail_golovackii.developmentTeams.repository.SkillRepository;
import com.mikhail_golovackii.developmentTeams.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

public class SkillRepositoryImpl implements SkillRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(Skill elem) {
        
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(elem);
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            System.out.println("Such an element exists in the database");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void updateById(Skill elem) {
        Skill skill = getById(elem.getId());

        if (skill == null) {
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
    public Skill getById(int id) {
        
        try (Session session = sessionFactory.openSession()) {
            return session.get(Skill.class, id);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Skill> getAll() {
        
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Skill").getResultList();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void deleteById(int id) {
 
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Skill skill = session.get(Skill.class, id);

            if (skill != null) {
                session.delete(skill);
            }

        session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
