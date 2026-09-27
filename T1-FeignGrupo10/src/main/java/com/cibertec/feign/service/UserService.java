package com.cibertec.feign.service;

import com.cibertec.feign.client.UserClient;
import com.cibertec.feign.dto.UserPlaceHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient userClient;

    // /users NO trae el atributo userId (solo id, name, username, email, address, phone, website, company),
    // por eso acá solo se puede aplicar el filtro de id impar.
    public List<UserPlaceHolder> getUsersIdImpar() {
        return userClient.getUsers().stream()
                .filter(u -> u.getId() != null && u.getId() % 2 != 0)
                .toList();
    }

    // /posts sí trae userId e id, así que se aplican los dos filtros del enunciado:
    // userId par e id impar.
    public List<UserPlaceHolder> getPostsUserIdParIdImpar() {
        return userClient.getPosts().stream()
                .filter(u -> u.getUserId() != null && u.getUserId() % 2 == 0)
                .filter(u -> u.getId() != null && u.getId() % 2 != 0)
                .toList();
    }
}
