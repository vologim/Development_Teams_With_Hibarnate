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
    private Session session;

    @Override
    public void save(Skill elem) {
        session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(elem);
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            System.out.println("Such an element exists in the database");
        } finally {
            session.close();
        }
    }

    @Override
    public void updateById(int id, Skill elem) {
        Skill skill = getById(id);
        
        if (skill == null) {
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
    public Skill getById(int id) {
        Skill skill = new Skill();

        session = sessionFactory.openSession();
        session.beginTransaction();
        skill = session.get(Skill.class, id);
        session.getTransaction().commit();
        session.close();

        return skill;
    }

    @Override
    public List<Skill> getAll() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Skill> skills = session.createQuery("FROM Skill").getResultList();
        session.getTransaction().commit();
        session.close();

        return skills;
    }

    @Override
    public void deleteById(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Skill skill = session.get(Skill.class, id);

        if (skill != null) {
            session.delete(skill);
        }

        session.getTransaction().commit();
        session.close();
    }

}
