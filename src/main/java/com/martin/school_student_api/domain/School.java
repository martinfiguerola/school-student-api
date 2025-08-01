package com.martin.school_student_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "T_SCHOOL")
@Getter // Generates all getters
@Setter // Generates all setters
@NoArgsConstructor // Required by JPA: no-argument constructor
@ToString // Generates toString()
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String name;
    private String address;
    @Column(length = 20)
    private String phone;
}
