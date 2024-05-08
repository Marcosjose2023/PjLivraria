package com.livraria.livraria.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutoresDto {
    private Long id;
    private String nome;
    private boolean ativo;
}
