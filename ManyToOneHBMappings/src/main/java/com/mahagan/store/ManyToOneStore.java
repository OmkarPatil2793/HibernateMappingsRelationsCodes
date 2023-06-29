package com.mahagan.store;

import com.mahagan.entities.Country;
import com.mahagan.entities.State;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ManyToOneStore {

    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        State state1 = new State();
        state1.setStateName("MadhyaPradesh");
        state1.setStateCapital("Bhopal");
        state1.setStateCode(9);
        state1.setStateInitial("MP");
        state1.setStateOriginYear(1952);


        State state2 = new State();
        state2.setStateName("UttarPradesh");
        state2.setStateCapital("Lucknow");
        state2.setStateCode(14);
        state2.setStateInitial("UP");
        state2.setStateOriginYear(1943);

        State state3 = new State();
        state3.setStateName("Bihar");
        state3.setStateCapital("Patana");
        state3.setStateCode(7);
        state3.setStateInitial("BH");
        state3.setStateOriginYear(1990);

        Country country = new Country();
        country.setCountryName("India");
        country.setCountryCapital("Delhi");
        country.setCountryCode(+91);

        state1.setCountry(country);
        state2.setCountry(country);
        state3.setCountry(country);

        session.persist(state1);
        session.persist(state2);
        session.persist(state3);

        transaction.commit();
        session.close();

        System.out.println("Data Stored Successfully!!!!");

    }
}
