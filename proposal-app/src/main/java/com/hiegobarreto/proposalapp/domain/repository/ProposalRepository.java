package com.hiegobarreto.proposalapp.domain.repository;

import com.hiegobarreto.proposalapp.domain.entities.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    List<Proposal> findAllByIntegradaIsFalse();

    @Transactional
    @Modifying
    @Query(value = "UPDATE proposal SET aprovada = :approved, observacao = :note WHERE id = :id", nativeQuery = true)
    void updateProposal(Long id, boolean approved, String note);
}
