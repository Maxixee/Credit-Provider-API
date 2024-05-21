package com.hiegobarreto.proposalapp.domain.repository;

import com.hiegobarreto.proposalapp.domain.entities.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    List<Proposal> findAllByIntegradaIsFalse();
}
