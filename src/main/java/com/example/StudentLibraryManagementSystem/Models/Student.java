package com.example.StudentLibraryManagementSystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id //primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to insure auto generated id
    private int id;

    private String name;

    private int age;

    @Column(unique = true)     //to make this column unique
    private String email;

    private String mobile_no;

    private String country;

    //syntax and annotations for bidirectional mapping
    @OneToOne(mappedBy = "studentVariableName",cascade =CascadeType.ALL)
    private Card card;

    /*
        Steps to find that variable
        1. Go the child class (In this case)
        2. Out of all the attributes select the foreign key attribute that is helping you connect
        with parent class
        (Ref :  @OneToOne
                @JoinColumn
                private Student studentVariableName;
        )
        3. Choose the variable name of the parentEnty (reference : studentVariableName)
     */


    //constructors & getters setters
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_no() {
        return mobile_no;
    }
    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
}
