package com.martin.school_student_api.dto.school;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // Generates all getters
@Setter // Generates all setters
@ToString
public class SchoolRequestDTO {
    private String name;
    private String address;
    private String phone;
}
