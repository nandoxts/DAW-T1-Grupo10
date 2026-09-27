package com.cibertec.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Sirve para /users (id, name, username, email) y para /posts (userId, id, title, body)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPlaceHolder {
    private Integer id;
    private Integer userId;
    private String name;
    private String username;
    private String email;
    private String title;
    private String body;
}
