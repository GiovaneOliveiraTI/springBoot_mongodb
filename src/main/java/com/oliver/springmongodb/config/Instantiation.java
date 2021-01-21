package com.oliver.springmongodb.config;

import com.oliver.springmongodb.DTOs.AuthorDTO;
import com.oliver.springmongodb.domain.Post;
import com.oliver.springmongodb.domain.User;
import com.oliver.springmongodb.repositories.PostRepository;
import com.oliver.springmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

         userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post = new Post(null, sdf.parse("21/10/2018"), "Partiu viagem para Arinos", "Vou viajar para Arinos. Abraços!", new AuthorDTO(alex));
        Post post1 = new Post(null, sdf.parse("21/10/2018"), "Partiu viagem para Unai", "Vou viajar para Unai. Abraços!", new AuthorDTO(bob));
        Post post2 = new Post(null, sdf.parse("21/10/2018"), "Partiu viagem brasilia", "Vou viajar para brasilia. Abraços!", new AuthorDTO(maria));


        postRepository.saveAll(Arrays.asList(post, post1, post2));

    }
}
