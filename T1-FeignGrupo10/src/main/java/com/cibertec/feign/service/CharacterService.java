package com.cibertec.feign.service;

import com.cibertec.feign.client.CharacterClient;
import com.cibertec.feign.dto.CharacterRM;
import com.cibertec.feign.dto.CharacterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterClient characterClient;

    // Personajes de la primera página con status "Alive" y species "Human"
    public List<CharacterRM> getHumanosVivos() {
        CharacterResponse response = characterClient.getCharacters();
        if (response == null || response.getResults() == null) {
            return List.of();
        }
        return response.getResults().stream()
                .filter(c -> "Alive".equalsIgnoreCase(c.getStatus()))
                .filter(c -> "Human".equalsIgnoreCase(c.getSpecies()))
                .toList();
    }
}
