package com.ecommerce.api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    @NotNull(message = "Id é obrigatório para atualização")
    private Long id;

    private String name;

    @Email(message = "Email deve ser válido")
    private String email;

    @NotNull(message = "Senha é obrigatória")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
    private String password;

    private String roles;

    private String phone;

    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate birthDate;

    @AssertTrue(message = "Usuário deve ser maior de idade")
    public boolean isAdult() {
        if (birthDate == null) {
            return false;
        }
        return birthDate.isBefore(LocalDate.now().minusYears(18));
    }
}
