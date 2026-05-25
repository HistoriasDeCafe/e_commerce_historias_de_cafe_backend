package com.historias_de_cafe.backend.service;

import com.historias_de_cafe.backend.model.User;
import com.historias_de_cafe.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPasswordHash(user.getPasswordHash());
        existing.setCreationDate(user.getCreationDate());
        existing.setStateActive(user.getStateActive());
        existing.setRole(user.getRole());
        return userRepository.save(existing);
    }

    // metodo de prueba - path actualiza por campo
    public User patch(Long id, Map<String, Object> fields) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing == null) return null;
        if (fields.containsKey("name")) existing.setName((String) fields.get("name"));
        if (fields.containsKey("email")) existing.setEmail((String) fields.get("email"));
        return userRepository.save(existing);
    }

    public void delete(Long id) {userRepository.deleteById(id);}

}
