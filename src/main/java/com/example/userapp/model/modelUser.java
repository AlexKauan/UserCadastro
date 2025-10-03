package main.java.com.example.userapp.model;

import java.time.LocalDateTime;

public class modelUser {

private Long id;
private String nome;
private String email;
private String senhaHash;
private LocalDateTime criadoEm;

public modelUser() {
    this.criadoEm = LocalDateTime.now();
}

public modelUser(Long id, String nome, String email, String senhaHash) {
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

public LocalDateTime getCriadoEm() {
    return criadoEm;
}

public boolean checkSenha(String senha) { if (this.senhaHash == null) return false; return PasswordUtil.verifyPassword(senha, this.senhaHash); }


@Override
public String toString() {
    return "Usuario{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", email='" + email + '\'' +
            ", criadoEm=" + criadoEm +
            '}';
}
}
