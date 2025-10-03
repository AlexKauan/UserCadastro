package com.example.userapp.model;

import java.time.LocalDateTime;

import com.example.userapp.util.PasswordUtil;

public class ModelUser {

    private Long id;
    private String nome;
    private String email;
    private String senhaHash;
    private LocalDateTime criadoEm;

    public ModelUser() {
        this.criadoEm = LocalDateTime.now();
    }

    public ModelUser(Long id, String nome, String email, String senhaHash) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public void setSenhaPlain(String senha) {
        if (senha != null && !senha.trim().isEmpty()) {
            this.senhaHash = PasswordUtil.hashPassword(senha);
        }
    }

    public boolean checkSenha(String senha) {
        if (this.senhaHash == null) {
            return false;
        }
        return PasswordUtil.verifyPassword(senha, senhaHash);
    }

    public void validate() {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email deve ter formato válido");
        }
        if (senhaHash == null || senhaHash.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória");
        }
    }

    @Override
    public String toString() {
        return "ModelUser{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", criadoEm=" + criadoEm +
                '}';
    }
}
