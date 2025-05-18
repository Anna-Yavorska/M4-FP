package org.example.util;

import lombok.Getter;
import org.example.dao.CityDAO;
import org.example.domain.City;
import org.example.domain.Country;
import org.example.domain.CountryLanguage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.List;
import java.util.Properties;
import java.util.Set;


public class HibernateUtil {

    @Getter
    private static final SessionFactory sessionFactory;

    static {
        try {
            Properties hibernate = new Properties();

            hibernate.setProperty(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
            hibernate.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

            hibernate.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            hibernate.setProperty(Environment.HBM2DDL_AUTO, "validate");
            hibernate.setProperty(Environment.STATEMENT_BATCH_SIZE, "100");

            hibernate.setProperty(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/world");
            hibernate.setProperty(Environment.USER, "root");
            hibernate.setProperty(Environment.PASS, "root");

            Configuration configuration = new Configuration();
            configuration.addProperties(hibernate);

            configuration.addAnnotatedClass (Country.class) ;
            configuration.addAnnotatedClass (CountryLanguage.class) ;
            configuration.addAnnotatedClass (City.class);

            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }


    public static void testMysqlData(List<Integer> ids, CityDAO cityDAO) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            for (Integer id : ids) {
                City city = cityDAO.getById(id);
                Set<CountryLanguage> languages = city.getCountry().getLanguages();
            }
            session.getTransaction().commit();
        }
    }
}