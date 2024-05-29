package com.hiegobarreto.credit_analysis.domain.entities;

import lombok.Getter;
import lombok.Setter;

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
