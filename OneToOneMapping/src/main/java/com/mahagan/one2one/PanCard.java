package com.mahagan.one2one;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class PanCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pc_Id;

    private String panCardNumber;

    @OneToOne(mappedBy = "panCard")
    @Cascade(value = CascadeType.ALL)
    private Person person;

    public PanCard(int pc_Id, String panCardNumber, Person person) {
        this.pc_Id = pc_Id;
        this.panCardNumber = panCardNumber;
        this.person = person;
    }

    public PanCard() {
    }

    public int getPc_Id() {
        return pc_Id;
    }

    public void setPc_Id(int pc_Id) {
        this.pc_Id = pc_Id;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
