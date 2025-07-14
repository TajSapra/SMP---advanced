package com.mysmppracticeadvwebdev.users.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "Email of user cannot be blank")
    @Email(message = "Email should be a valid mail id")
    public String email;

    @NotBlank(message = "Name of user cannot be blank")
    public String name;

    public String id;

    @NotBlank(message = "Phone Number of a user cannot be blank")
    @Size(min=10, max=10, message = "Phone Number should be a valid 10 digit number")
    public String phone_number; /// use for 2FA using whatsapp. Add a communications service later

    public Boolean is_phone_verified;

    @NotBlank(message = "Phone Number of a user cannot be blank")
    public String password;

}
