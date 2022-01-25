
package com.mikhail_golovackii.developmentTeams.utils;

import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.entity.Skill;
import com.mikhail_golovackii.developmentTeams.entity.Team;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static HibernateUtil instance;
    private static SessionFactory sessionFactory;
    
    private HibernateUtil() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Developer.class)
                .addAnnotatedClass(Skill.class)
                .addAnnotatedClass(Team.class)
                .buildSessionFactory();  
    }
    
    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }
    
    public static SessionFactory getSessionFactory() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return sessionFactory;
    }
}
