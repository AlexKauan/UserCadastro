package com.arquitetura_de_software.userapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arquitetura_de_software.userapp.model.ModelUser;

@Repository
public interface UserRepository extends JpaRepository<ModelUser, Long> {

}
