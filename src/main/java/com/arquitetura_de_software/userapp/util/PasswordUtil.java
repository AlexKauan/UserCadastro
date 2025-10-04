package com.arquitetura_de_software.userapp.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
  private static final int WORKLOAD = 12;

  public static String hashPassword(String plainPassword) {
    if (plainPassword == null) {
      throw new IllegalArgumentException("Senha não pode ser nula");
    }
    return BCrypt.hashpw(plainPassword, BCrypt.gensalt(WORKLOAD));
  }

  public static boolean verifyPassword(String plainPassword, String storedHash) {
    if (storedHash == null || storedHash.length() == 0) {
      return false;
    }
    return BCrypt.checkpw(plainPassword, storedHash);
  }
}
