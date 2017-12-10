package com.no_company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "chirrup")
public class UsersEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false) private int id;
    @Column(unique = true) private String nickname;
    @Column(name = "first_name") private String firstName;
    @Column(name = "last_name") private String lastName;
    @Column private String password;

}