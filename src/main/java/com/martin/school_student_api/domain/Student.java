package com.martin.school_student_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "T_STUDENT")
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40)
    private String firstname;
    @Column(length = 40)
    private String lastname;
    @Column(unique = true)
    private String email;

}
