package com.hiegobarreto.notificationapp.domain.entities;

import lombok.*;

@Setter
@Getter
public class Proposal {

    private Long id;
    private Double valorSolicitado;
    private int prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;
    private User usuario;

}
