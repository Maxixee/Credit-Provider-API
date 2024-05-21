package com.hiegobarreto.proposalapp.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_proposal")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "amount")
    private Double valorSolicitado;
    @Column(name = "payment_term")
    private int prazoPagamento;
    @Column(name = "approved")
    private Boolean aprovada;
    @Column(name = "integrated")
    private boolean integrada;
    @Column(name = "note")
    private String observacao;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user")
    @JsonManagedReference
    private User usuario;

}
