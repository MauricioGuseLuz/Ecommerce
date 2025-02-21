package com.ecommerce.api.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    @NotNull(message = "Id é obrigatório para atualização")
    private Long id;

    @Pattern(regexp = "^[a-zA-ZÀ-ú ]+$", message = "Nome deve conter apenas letras e espaços")
    private String name;

    @Email(message = "Email deve ser válido")
    private String email;

    @NotNull(message = "Senha é obrigatória")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).+$", message = "A senha deve conter pelo menos um número, uma letra maiúscula, uma letra minúscula e um caractere especial")
    private String password;

    @Pattern(regexp = "^(ADMIN|USER|MANAGER)$", message = "Role deve ser uma das opções: ADMIN, USER, MANAGER")
    private String roles;

    @Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", message = "Telefone deve seguir o padrão (xx) xxxxx-xxxx")
    private String phone;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Data de nascimento deve estar no formato YYYY-MM-DD")
    private String birthDate;

    @AssertTrue(message = "Usuário deve ser maior de idade")
    public boolean isAdult() {

        return LocalDate.parse(birthDate).isBefore(LocalDate.now().minusYears(18));
    }

}
