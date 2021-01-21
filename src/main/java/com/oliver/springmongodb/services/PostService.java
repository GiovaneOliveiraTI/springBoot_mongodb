package com.oliver.springmongodb.services;

import com.oliver.springmongodb.domain.Post;
import com.oliver.springmongodb.domain.User;
import com.oliver.springmongodb.exceptions.ObjectNotFoundException;
import com.oliver.springmongodb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));

    }

}
