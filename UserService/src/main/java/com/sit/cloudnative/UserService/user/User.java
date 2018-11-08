package com.sit.cloudnative.UserService.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    private String department;
    @NotBlank
    private String faculty;
    @NotNull
    private int studentYear;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public User() {

    }

    public long getStudentId() {
        return this.studentId;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public int getStudentYear() {
        return this.studentYear;
    }

}
