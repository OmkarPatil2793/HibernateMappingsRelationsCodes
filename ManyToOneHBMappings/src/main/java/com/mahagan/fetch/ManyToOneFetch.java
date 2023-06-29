package com.mahagan.fetch;

import com.mahagan.entities.Country;
import com.mahagan.entities.State;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class ManyToOneFetch {
    public static void main(String[] args) {
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();

        TypedQuery query=session.createQuery("from State s");
        List<State> list=query.getResultList();

        Iterator<State> itr=list.iterator();
        while(itr.hasNext()){
            State state=itr.next();
            System.out.println(
                    "State Name     : " +state.getStateName()       + "\n " +
                    "State Code     : " +state.getStateCode()       + "\n " +
                    "State Capital  : " +state.getStateCapital()    + "\n " +
                    "State Initial  : " +state.getStateInitial()    + "\n " +
                    "State Origin Year : " +state.getStateOriginYear());
            Country country = state.getCountry();
            System.out.println(
                    "Country Name : " + country.getCountryName() + "\n" +
                    "Country Capital : " + country.getCountryCapital() + "\n" +
                    "Cpuntry Code : "  + country.getCountryCode());
        }

        session.close();
        System.out.println("success");
    }
}