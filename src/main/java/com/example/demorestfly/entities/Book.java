package com.example.demorestfly.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "books")
@EqualsAndHashCode(callSuper = true)
@NamedQuery(name = "Book.findByParams",
        query = "select u from Book u where u.description = ?1")
public class Book extends BaseEntity implements Serializable {

    private String name;
    private String description;

}
