package com.tym.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String post;
    @Column(nullable = false)
    private int age;

    public User() {
    }

    public User(String name, String post, int age) {
        this.name = name;
        this.post = post;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", age=" + age +
                '}';
    }
}
