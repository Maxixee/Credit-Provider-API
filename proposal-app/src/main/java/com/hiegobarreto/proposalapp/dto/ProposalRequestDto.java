package com.hiegobarreto.proposalapp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProposalRequestDto {

    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;
    private Double renda;
    private Double valorSolicitado;
    private int prazoPagamento;
}
