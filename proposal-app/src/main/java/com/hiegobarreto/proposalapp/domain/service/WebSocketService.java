package com.hiegobarreto.proposalapp.domain.service;

import com.hiegobarreto.proposalapp.dto.ProposalResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void notify(ProposalResponseDto proposal){
        template.convertAndSend("/propostas", proposal);
    }
}
