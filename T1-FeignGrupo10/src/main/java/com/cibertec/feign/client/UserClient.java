package com.cibertec.feign.client;

import com.cibertec.feign.dto.UserPlaceHolder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "userClient", url = "https://jsonplaceholder.typicode.com")
public interface UserClient {

    @GetMapping("/users")
    List<UserPlaceHolder> getUsers();

    @GetMapping("/posts")
    List<UserPlaceHolder> getPosts();
}
