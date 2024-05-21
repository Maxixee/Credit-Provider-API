package com.hiegobarreto.proposalapp.domain.entities;

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
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "payment_term", nullable = false)
    private int paymentTerm;
    @Column(name = "approved", nullable = false)
    private Boolean approved;
    @Column(name = "integrated", nullable = false)
    private boolean integrated;
    @Column(name = "note", nullable = false)
    private String note;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
