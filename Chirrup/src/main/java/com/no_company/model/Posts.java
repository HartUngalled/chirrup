package com.no_company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "posts", schema = "chirrup")
public class Posts implements ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false) private int id;
    @Column private String message;
    @Column @Type(type="timestamp") private Date time;

    @ManyToOne
    @JoinColumn(name="users_id")
    private Users user;

    public String getPrettyTime() {
        PrettyTime pt = new PrettyTime(Locale.UK);
        return pt.format(time);
    }


}
