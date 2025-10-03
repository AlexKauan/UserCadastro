package com.example.userapp.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.userapp.model.ModelUser;

public class UsuarioTest {

    private ModelUser usuario;

    @BeforeEach
    void setUp() {
        usuario = new ModelUser(null, "Alex Kauan", "alex.k@example.com", null);
    }

    @Test
    void testSenhaHashingAndValidation() {
        usuario.setSenhaPlain("SenhaSegura123!");

        assertDoesNotThrow(() -> usuario.validate(), "Validação deve passar com dados válidos");

        assertTrue(usuario.checkSenha("SenhaSegura123!"), "Senha deve validar corretamente");
        assertFalse(usuario.checkSenha("senhaErrada"), "Senha incorreta deve falhar");
    }

    @Test
    void testValidacaoNomeObrigatorio() {
        usuario.setNome(null);
        usuario.setSenhaPlain("senha123");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> usuario.validate(), "Deve lançar exceção para nome nulo");
        assertEquals("Nome é obrigatório", exception.getMessage());
    }

    @Test
    void testValidacaoEmailObrigatorio() {
        usuario.setEmail(null);
        usuario.setSenhaPlain("senha123");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> usuario.validate(), "Deve lançar exceção para email nulo");
        assertEquals("Email é obrigatório", exception.getMessage());
    }

    @Test
    void testValidacaoEmailFormato() {
        usuario.setEmail("emailInvalido");
        usuario.setSenhaPlain("senha123");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> usuario.validate(), "Deve lançar exceção para email inválido");
        assertEquals("Email deve ter formato válido", exception.getMessage());
    }

    @Test
    void testValidacaoSenhaObrigatoria() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> usuario.validate(), "Deve lançar exceção para senha não definida");
        assertEquals("Senha é obrigatória", exception.getMessage());
    }
}
