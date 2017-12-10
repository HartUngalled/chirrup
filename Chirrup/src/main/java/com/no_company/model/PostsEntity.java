package com.no_company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts", schema = "chirrup")
public class PostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false) private int id;
    @Column private String message;
    @Column @Type(type="timestamp") private Date time;

    @ManyToOne
    @JoinColumn(name="users_id")
    private UsersEntity user;

}
