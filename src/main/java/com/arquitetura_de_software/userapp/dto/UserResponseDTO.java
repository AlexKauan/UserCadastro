package com.arquitetura_de_software.userapp.dto;

import java.time.LocalDateTime;

import com.arquitetura_de_software.userapp.model.ModelUser;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de resposta com dados do usuário")
public class UserResponseDTO {
    @Schema(description = "ID único do usuário", example = "1")
    private Long id;
    
    @Schema(description = "Nome completo do usuário", example = "João Silva")
    private String name;
    
    @Schema(description = "Email do usuário", example = "joao.silva@example.com")
    private String email;
    
    @Schema(description = "Data e hora de criação do usuário", example = "2025-10-03T22:55:09.657")
    private LocalDateTime createdAt;

    public UserResponseDTO() {
    }

    public UserResponseDTO(ModelUser user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}