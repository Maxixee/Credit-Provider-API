package com.hiegobarreto.proposalapp.web.controllers;

import com.hiegobarreto.proposalapp.domain.service.ProposalService;
import com.hiegobarreto.proposalapp.dto.ProposalRequestDto;
import com.hiegobarreto.proposalapp.dto.ProposalResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/proposta")
public class ProposalController {

    private final ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalResponseDto> create(@RequestBody ProposalRequestDto requestDto){
        ProposalResponseDto response = this.proposalService.create(requestDto);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri())
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProposalResponseDto>> getAllProposal(){
        return ResponseEntity.ok(this.proposalService.getAll());
    }
}
