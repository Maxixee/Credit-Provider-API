package com.hiegobarreto.proposalapp.domain.entities;

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
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "rent", nullable = false)
    private Double rent;
    @OneToOne(mappedBy = "user")
    private Proposal proposal;
}
