package com.oliver.springmongodb.DTOs;

import com.oliver.springmongodb.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO(User obj) {

        id = obj.getId();
        name = obj.getName();

    }
}
