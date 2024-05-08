package com.livraria.livraria.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExceptionReturn {
    private Integer status;
    private String error;
    private Object extra;
}
