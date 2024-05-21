package com.hiegobarreto.proposalapp.domain.repository;

import com.hiegobarreto.proposalapp.domain.entities.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

}
