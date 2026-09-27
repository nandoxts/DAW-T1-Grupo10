package com.cibertec.feign.client;

import com.cibertec.feign.dto.CharacterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "characterClient", url = "https://rickandmortyapi.com/api")
public interface CharacterClient {

    // Sin el parámetro "page" la API devuelve solo la primera página
    @GetMapping("/character")
    CharacterResponse getCharacters();
}
