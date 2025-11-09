package group.dl.backend.application.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
    @Email(message = "E-mail inválido.") @NotBlank(message = "O e-mail é obrigatório.") String email,

    @NotBlank(message = "O nome é obrigatório.") @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.") String name,

    @NotBlank(message = "A senha é obrigatória.") @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.") String password) {
}
