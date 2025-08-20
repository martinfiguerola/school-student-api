package com.martin.school_student_api.dto.student;

import com.martin.school_student_api.domain.School;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentRequestDTO {

    @NotBlank(message = "firstname cannot be blank")
    private String firstname;
    @NotBlank(message = "lastname cannot be blank")
    private String lastname;
    @Email
    private String email;
    private Long school;
}
