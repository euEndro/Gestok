package group.dl.backend.application.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
    @Email(message = "E-mail inválido.") @NotBlank(message = "O e-mail é obrigatório.") @Size(min = 2, max = 150, message = "O email deve ter entre 2 e 150 caracteres.") String email,

    @NotBlank(message = "O nome é obrigatório.") @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.") String name,

    @NotBlank(message = "A senha é obrigatória.") @Size(min = 6, max = 64, message = "A senha deve ter entre 6 e 64 caracteres.") String password) {
}
