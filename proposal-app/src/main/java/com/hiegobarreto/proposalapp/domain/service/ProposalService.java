package com.hiegobarreto.proposalapp.domain.service;

import com.hiegobarreto.proposalapp.domain.entities.Proposal;
import com.hiegobarreto.proposalapp.domain.repository.ProposalRepository;
import com.hiegobarreto.proposalapp.dto.ProposalRequestDto;
import com.hiegobarreto.proposalapp.dto.ProposalResponseDto;
import com.hiegobarreto.proposalapp.mapper.ProposalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProposalService {

    private final ProposalRepository proposalRepository;

    @Transactional
    public ProposalResponseDto create(ProposalRequestDto responseDto){
        Proposal proposal = ProposalMapper.INSTANCE.convertDtoToProposal(responseDto);
        proposalRepository.save(proposal);

        return ProposalMapper.INSTANCE.convertEntityToDto(proposal);
    }

    public List<ProposalResponseDto> getAll() {
        return ProposalMapper.INSTANCE.convertListEntityToListDto(proposalRepository.findAll());
    }
}
