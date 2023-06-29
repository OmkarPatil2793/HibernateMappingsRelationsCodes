package com.mahagan.one2one;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Person {
    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen",strategy = "foreign",parameters = {@org.hibernate.annotations.Parameter(name = "property",value = "panCard")})
    private int person_Id;

    private String person_firstName;
    private String person_lastName;
    private int person_birthYear;

    @OneToOne
    @PrimaryKeyJoinColumn
    private PanCard panCard;

    public Person() {

    }

    public int getPerson_Id() {
        return person_Id;
    }

    public void setPerson_Id(int person_Id) {
        this.person_Id = person_Id;
    }

    public String getPerson_firstName() {
        return person_firstName;
    }

    public void setPerson_firstName(String person_firstName) {
        this.person_firstName = person_firstName;
    }

    public String getPerson_lastName() {
        return person_lastName;
    }

    public void setPerson_lastName(String person_lastName) {
        this.person_lastName = person_lastName;
    }

    public int getPerson_birthYear() {
        return person_birthYear;
    }

    public void setPerson_birthYear(int person_birthYear) {
        this.person_birthYear = person_birthYear;
    }

    public PanCard getPanCard() {
        return panCard;
    }

    public void setPanCard(PanCard panCard) {
        this.panCard = panCard;
    }

    public Person(int person_Id, String person_firstName, String person_lastName, int person_birthYear, PanCard panCard) {
        this.person_Id = person_Id;
        this.person_firstName = person_firstName;
        this.person_lastName = person_lastName;
        this.person_birthYear = person_birthYear;
        this.panCard = panCard;
    }
}
