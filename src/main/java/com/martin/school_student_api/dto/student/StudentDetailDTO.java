package com.martin.school_student_api.dto.student;

import com.martin.school_student_api.dto.school.SchoolRefDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDetailDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private SchoolRefDTO school;
}
