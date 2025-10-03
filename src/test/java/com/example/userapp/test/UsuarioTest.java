package test.java.com.example.userapp.test;

import main.java.com.example.userapp.model.modelUser;

public class UsuarioTest {

public void testSenhaHashingAndValidation() {
    modelUser u = new modelUser(null, "Alex Kauan", "alex.k@example.com", null);
    u.setSenhaPlain("SenhaSegura123!");
    // validações de negócio
    u.validate();

    // verifica que a senha correta passa e a incorreta falha
    assertTrue(u.checkSenha("SenhaSegura123!"), "Senha deve validar corretamente");
    assertFalse(u.checkSenha("senhaErrada"));
}

}
