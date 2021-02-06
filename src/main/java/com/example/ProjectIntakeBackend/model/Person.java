package com.example.ProjectIntakeBackend.model;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "person")
//@Data
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String email;
    public String citizens_id;
    

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", citizens_id='" + citizens_id + '\'' +
                '}';
    }
}