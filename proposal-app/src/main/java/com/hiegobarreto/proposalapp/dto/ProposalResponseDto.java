package com.hiegobarreto.proposalapp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProposalResponseDto {

    private Long id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;
    private Double renda;
    private String valorSolicitadoFmt;
    private int prazoPagamento;
    private Boolean aprovada;
    private String observacao;
}
