package com.oliver.springmongodb.repositories;

import com.oliver.springmongodb.domain.Post;
import com.oliver.springmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
