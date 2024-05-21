package com.hiegobarreto.proposalapp.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name")
    private String nome;
    @Column(name = "last_name")
    private String sobrenome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "phone")
    private String telefone;
    @Column(name = "rent")
    private Double renda;
    @OneToOne(mappedBy = "usuario")
    @JsonBackReference
    private Proposal proposta;
}
