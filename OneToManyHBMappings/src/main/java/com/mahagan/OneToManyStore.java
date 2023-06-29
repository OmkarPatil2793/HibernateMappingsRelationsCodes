package com.mahagan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public class OneToManyStore {
    public static void main(String[] args) {

        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();

        Transaction t=session.beginTransaction();

        Answer answer1 = new Answer();
        answer1.setAnsName("Java is Programming Language.");
        answer1.setAnsPostedBy("Krishna Shinde");

        Answer answer2 = new Answer();
        answer2.setAnsName("Java is Platform Independent.");
        answer2.setAnsPostedBy("VijayKunar Mohite");

        Answer answer3 = new Answer();
        answer3.setAnsName("Spring Is LightWeight Framework.");
        answer3.setAnsPostedBy("Ajay Dhole");

        Answer answer4 = new Answer();
        answer4.setAnsName("Spring is Used For WebApplications.");
        answer4.setAnsPostedBy("Vidhya Somvanshi");

        ArrayList<Answer> list1 = new ArrayList<>();
        list1.add(answer1);
        list1.add(answer2);

        ArrayList<Answer> list2 = new ArrayList<>();
        list2.add(answer3);
        list2.add(answer4);

        Question question1 = new Question();
        question1.setQueName("What is features of Java?");
        question1.setAnswers(list1);

        Question question2 = new Question();
        question2.setQueName("What is features of Spring?");
        question2.setAnswers(list2);

        session.persist(question1);
        session.persist(question2);

        t.commit();
        session.close();

        System.out.println("Successfully Added!!!");
    }
}