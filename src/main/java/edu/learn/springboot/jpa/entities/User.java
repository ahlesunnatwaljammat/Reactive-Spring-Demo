package edu.learn.springboot.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/*@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "password")
@Entity
public class User implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}*/
