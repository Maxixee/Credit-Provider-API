package com.hiegobarreto.credit_analysis.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private Double renda;
}
