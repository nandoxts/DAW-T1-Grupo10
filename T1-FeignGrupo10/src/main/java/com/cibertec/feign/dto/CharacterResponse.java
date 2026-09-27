package com.cibertec.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Envoltorio de la respuesta de Rick and Morty: { "info": {...}, "results": [...] }
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterResponse {
    private Info info;
    private List<CharacterRM> results;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Info {
        private Integer count;
        private Integer pages;
        private String next;
        private String prev;
    }
}
