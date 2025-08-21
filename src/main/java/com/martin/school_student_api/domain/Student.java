package com.martin.school_student_api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    // tells Jackson: "This is the side that should be ignored.When serializing a Student,
    // do not include the entire School object to avoid the loop."
    private School school;

}
