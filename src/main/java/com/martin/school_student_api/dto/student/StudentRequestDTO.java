package com.martin.school_student_api.dto.student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentRequestDTO {

    private String firstname;
    private String lastname;
    private String email;
}
