package com.ecommerce.api.services;

import com.ecommerce.api.dto.UserDTO;
import com.ecommerce.api.entities.User;
import com.ecommerce.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        user = userRepository.save(user);
        return convertToDto(user);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + id));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRoles(userDTO.getRoles());
        user.setPhone(userDTO.getPhone());
        user.setBirthDate(userDTO.getBirthDate());

        user = userRepository.save(user);
        return convertToDto(user);
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + id));

        return convertToDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDTO deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + id));
        userRepository.delete(user);
        return null;
    }

    private UserDTO convertToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRoles(user.getRoles());
        dto.setPhone(user.getPhone());
        dto.setBirthDate(user.getBirthDate());

        return dto;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRoles(userDTO.getRoles());
        user.setPhone(userDTO.getPhone());
        user.setBirthDate(userDTO.getBirthDate());

        return user;
    }
}
