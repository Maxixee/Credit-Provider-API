package com.hiegobarreto.proposalapp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProposalRequestDto {

    private String name;
    private String lastName;
    private String phone;
    private String cpf;
    private Double rent;
    private Double amount;
    private int paymentTerm;
}
