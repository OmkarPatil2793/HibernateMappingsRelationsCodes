package com.mahagan.store;

import com.mahagan.entities.Bank;
import com.mahagan.entities.Branch;
import com.mahagan.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public class OneToManyBankCustStore {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer1 = new Customer();
        customer1.setCustFirstName("Megha");
        customer1.setCustLastName("Patil");
        customer1.setCustMobileNo("8502657896");
        customer1.setCustBirthYear(1997);

        Customer customer2 = new Customer();
        customer2.setCustFirstName("Hruta");
        customer2.setCustLastName("Mane");
        customer2.setCustMobileNo("8596741425");
        customer2.setCustBirthYear(1995);

        Branch branch1 = new Branch();
        branch1.setBranchName("Main");
        branch1.setBranchLocation("Kolhapur");
        branch1.setBranchIFSC("ICICI1256");

        Branch branch2 = new Branch();
        branch2.setBranchName("Loan");
        branch2.setBranchLocation("Chakan");
        branch2.setBranchIFSC("ICICI2152");

        ArrayList<Customer> list = new ArrayList<>();
        list.add(customer1);
        list.add(customer2);

        ArrayList<Branch> branches = new ArrayList<>();
        branches.add(branch1);
        branches.add(branch2);

        Bank bank = new Bank();
        bank.setBankName("ICICI Bank Limited");
        bank.setBankType("Commercial");
        bank.setBankHeadOffice("Surat");
        bank.setCustomers(list);
        bank.setBranches(branches);

        session.persist(bank);

        transaction.commit();
        session.close();

        System.out.println("Data Uploaded Successfully!!");
    }
}
