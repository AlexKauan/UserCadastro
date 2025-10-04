package com.arquitetura_de_software.userapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para criação e atualização de usuários")
public class UserRequestDTO {
    @Schema(description = "Nome completo do usuário", example = "João Silva")
    private String name;
    
    @Schema(description = "Email do usuário", example = "joao.silva@example.com")
    private String email;
    
    @Schema(description = "Senha do usuário", example = "minhasenha123")
    private String password;

    public UserRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}