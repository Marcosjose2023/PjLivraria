package com.livraria.livraria.mapper;

import com.livraria.livraria.entity.Autores;
import com.livraria.livraria.dto.AutoresDto;

public class AutoresMapper {

    public static AutoresDto map(Autores autor){
        return AutoresDto
                .builder()
                .id(autor.getId())
                .nome(autor.getNome())
                .ativo(autor.isAtivo())
                .build();
    }
}
