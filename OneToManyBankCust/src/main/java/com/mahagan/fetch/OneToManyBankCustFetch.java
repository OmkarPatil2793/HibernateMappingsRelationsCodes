package com.mahagan.fetch;

import com.mahagan.entities.Bank;
import com.mahagan.entities.Branch;
import com.mahagan.entities.Customer;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class OneToManyBankCustFetch {

    public static void main(String[] args) {

        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        TypedQuery query = session.createQuery("from Bank");
        List<Bank> banks = query.getResultList();

        Iterator<Bank> iterator = banks.iterator();
        while (iterator.hasNext()){

            Bank bank = iterator.next();
            System.out.println("Bank Name Is :  " +bank.getBankName());

            List<Customer> customerList = bank.getCustomers();
            Iterator<Customer> customerIterator = customerList.iterator();
            while (customerIterator.hasNext()){
                Customer customer = customerIterator.next();
                System.out.println("Customer FirstName : " + customer.getCustFirstName());
                System.out.println("Customer LastName : "  + customer.getCustLastName());
                System.out.println("Customer Mobile No.  : " + customer.getCustMobileNo());
                System.out.println("Customer Birth Year  : " + customer.getcustBirthYear());
            }

            List<Branch> branchList = bank.getBranches();
            Iterator<Branch> branchIterator = branchList.iterator();
            while (branchIterator.hasNext()){
                Branch branch = branchIterator.next();
                System.out.println("Branch Name :  "  + branch.getBranchName());
                System.out.println("Branch Location :  "  + branch.getBranchLocation());
                System.out.println("Branch IFSC :  "  + branch.getBranchIFSC());
            }

           // session.close();
            System.out.println("Data Fetched Successfully!!!");
        }
    }
}
