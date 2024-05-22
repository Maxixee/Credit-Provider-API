package com.hiegobarreto.notificationapp.domain.entities;

import lombok.*;

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
