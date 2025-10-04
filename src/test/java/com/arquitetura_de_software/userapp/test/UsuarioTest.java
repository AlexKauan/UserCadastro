package com.arquitetura_de_software.userapp.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arquitetura_de_software.userapp.model.ModelUser;

class UsuarioTest {

    private ModelUser user;

    @BeforeEach
    void setUp() {
        user = new ModelUser(null, "Alex Kauan", "alex.k@example.com", null);
    }

    @Test
    void testPasswordHashingAndValidation() {
        user.setPasswordPlain("SenhaSegura123!");

        assertDoesNotThrow(() -> user.validate(), "Validação deve passar com dados válidos");

        assertTrue(user.checkPassword("SenhaSegura123!"), "Senha deve validar corretamente");
        assertFalse(user.checkPassword("senhaErrada"), "Senha incorreta deve falhar");
    }

    @Test
    void testValidacaoNomeObrigatorio() {
        user.setName(null);
        user.setPasswordPlain("senha123");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> user.validate(), "Deve lançar exceção para nome nulo");
        assertEquals("Nome é obrigatório", exception.getMessage());
    }

    @Test
    void testValidacaoEmailObrigatorio() {
        user.setEmail(null);
        user.setPasswordPlain("senha123");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> user.validate(), "Deve lançar exceção para email nulo");
        assertEquals("Email é obrigatório", exception.getMessage());
    }

    @Test
    void testValidacaoEmailFormato() {
        user.setEmail("emailInvalido");
        user.setPasswordPlain("senha123");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> user.validate(), "Deve lançar exceção para email inválido");
        assertEquals("Email deve ter formato válido", exception.getMessage());
    }

    @Test
    void testValidacaoSenhaObrigatoria() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> user.validate(), "Deve lançar exceção para senha não definida");
        assertEquals("Senha é obrigatória", exception.getMessage());
    }
}
