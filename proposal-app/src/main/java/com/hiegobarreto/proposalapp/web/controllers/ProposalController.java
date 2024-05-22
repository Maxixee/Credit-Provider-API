package com.hiegobarreto.proposalapp.web.controllers;

import com.hiegobarreto.proposalapp.domain.service.ProposalService;
import com.hiegobarreto.proposalapp.dto.ProposalRequestDto;
import com.hiegobarreto.proposalapp.dto.ProposalResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Tag(name = "Proposals", description = "Proposal API")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/proposta")
public class ProposalController {

    private final ProposalService proposalService;

    @Operation(summary = "Create Proposal", description = "Feature that creates a new proposal in the system",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Resource created successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProposalResponseDto.class))),
            })
    @PostMapping
    public ResponseEntity<ProposalResponseDto> create(@RequestBody ProposalRequestDto requestDto){
        ProposalResponseDto response = this.proposalService.create(requestDto);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri())
                .body(response);
    }

    @Operation(summary = "List users", description = "Feature to list all registered users",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of all registered users",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProposalResponseDto.class))))
            })
    @GetMapping
    public ResponseEntity<List<ProposalResponseDto>> getAllProposal(){
        return ResponseEntity.ok(this.proposalService.getAll());
    }
}
