package com.oliver.springmongodb.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Document(collection = "user")
@NoArgsConstructor
public class User implements Serializable {

    public static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true)
    private List<Post> posts= new ArrayList<>();


    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
