package com.example.demorestfly.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Serializable {

    @Column(name = "user_name")
    private String userName;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
