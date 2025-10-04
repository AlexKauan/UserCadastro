package com.arquitetura_de_software.userapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arquitetura_de_software.userapp.dto.UserRequestDTO;
import com.arquitetura_de_software.userapp.model.ModelUser;
import com.arquitetura_de_software.userapp.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ModelUser createUser(UserRequestDTO userRequest) {
        ModelUser newUser = new ModelUser();
        newUser.setName(userRequest.getName());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPasswordPlain(userRequest.getPassword());
        
        newUser.validate();
        return userRepository.save(newUser);
    }

    public List<ModelUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<ModelUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public ModelUser updateUser(Long id, UserRequestDTO userDetails) {
        ModelUser user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o id: " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPasswordPlain(userDetails.getPassword());
        }

        user.validate();
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com o id: " + id);
        }
        userRepository.deleteById(id);
    }
}