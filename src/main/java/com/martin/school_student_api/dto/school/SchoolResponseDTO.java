package com.martin.school_student_api.dto.school;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SchoolResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
}
