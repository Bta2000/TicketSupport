package com.codewithBita.ticketsupport.service;

import com.codewithBita.ticketsupport.aop.LogExecutionTime;
import com.codewithBita.ticketsupport.entity.TicketSupportEntity;
import com.codewithBita.ticketsupport.enums.TicketStatus;
import com.codewithBita.ticketsupport.exception.ResourceNotFoundException;
import com.codewithBita.ticketsupport.mapper.TicketSupportMapper;
import com.codewithBita.ticketsupport.model.TicketSupportModel;
import com.codewithBita.ticketsupport.repository.TicketSupportRepository;
import com.codewithBita.ticketsupport.validator.TicketSupportValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketSupportService {


    private final TicketSupportRepository ticketSupportRepository;
    private final TicketSupportMapper ticketSupportMapper;
    private final TicketSupportValidator ticketSupportValidator;


    @Transactional(rollbackFor = Exception.class)
    @LogExecutionTime
    public TicketSupportModel create(TicketSupportModel model) {

        ticketSupportValidator.validate(model);
        TicketSupportEntity entity = ticketSupportMapper.modelToEntity(model);
        ticketSupportRepository.save(entity);
        return ticketSupportMapper.entityToModel(entity);

    }

    @Transactional(readOnly = true)
    @LogExecutionTime
    public TicketSupportModel getById(Long id) {
        TicketSupportEntity entity = ticketSupportRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ticket not found with id: " + id)
                );
        return ticketSupportMapper.entityToModel(entity);
    }

    @Transactional(readOnly = true)
    @LogExecutionTime
    public Page<TicketSupportModel> getListOfTickets(Pageable pageable) {
        Page<TicketSupportEntity> entities = ticketSupportRepository.findAll(pageable);
        return entities.map(ticketSupportMapper::entityToModel);
    }

    @Transactional(rollbackFor = Exception.class)
    @LogExecutionTime
    public void updateTicketStatus(Long id , TicketStatus status) {
        TicketSupportEntity entity = ticketSupportRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ticket not found with id: " + id)
        );
        if (status != null)
            entity.setStatus(status);
    }
}