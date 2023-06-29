package com.mahagan.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OneToOneMappingHibernateApplication {
    public static void main(String[] args) {

        StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Person person = new Person();
        person.setPerson_firstName("Omkar");
        person.setPerson_lastName("Patil");
        person.setPerson_birthYear(1993);

        /*person.setPerson_firstName("Megha");
        person.setPerson_lastName("Patil");
        person.setPerson_birthYear(1996);*/

        PanCard panCard = new PanCard();
        panCard.setPanCardNumber("BXCPP2468P");
        /*panCard.setPanCardNumber("DABCP8452L");*/

        person.setPanCard(panCard);
        panCard.setPerson(person);

        session.persist(panCard);
        transaction.commit();

        session.close();
        System.out.println("Successfully data has been Saved ");





    }
}
