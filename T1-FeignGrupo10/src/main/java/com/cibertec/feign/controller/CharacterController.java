package com.cibertec.feign.controller;

import com.cibertec.feign.dto.CharacterRM;
import com.cibertec.feign.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping
    public List<CharacterRM> getCharacters() {
        return characterService.getHumanosVivos();
    }
}
