package com.martin.school_student_api.dto.school;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // Generates all getters
@Setter // Generates all setters
@ToString
public class SchoolRequestDTO {

    @NotBlank(message = "School name cannot be empty.")
    @Size(min = 3, max = 100, message = "School name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "School address cannot be empty")
    @Size(min = 5, max = 200, message = "School address must be between 5 and 200 characters")
    private String address;

    @NotBlank(message = "School phone cannot be empty")
    @Pattern(regexp = "^\\+?[0-9]{1,3}?[-\\s]?\\(?[0-9]{3}\\)?[-\\s]?[0-9]{3}[-\\s]?[0-9]{4,6}$",
            message = "Invalid phone number format.")
    private String phone;
}
