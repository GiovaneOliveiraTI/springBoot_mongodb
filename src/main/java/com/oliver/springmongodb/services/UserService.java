package com.oliver.springmongodb.services;

import com.oliver.springmongodb.DTOs.UserDTO;
import com.oliver.springmongodb.domain.User;
import com.oliver.springmongodb.exceptions.ObjectNotFoundException;
import com.oliver.springmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();

    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));

    }

    public UserDTO insertUser(UserDTO dto) {
        User user = new User(null, dto.getName(), dto.getEmail());
        user = repository.insert(user);
        return new UserDTO(user);
    }




}
