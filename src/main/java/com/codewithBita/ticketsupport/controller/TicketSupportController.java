package com.codewithBita.ticketsupport.controller;

import com.codewithBita.ticketsupport.enums.TicketStatus;
import com.codewithBita.ticketsupport.model.TicketSupportModel;
import com.codewithBita.ticketsupport.service.TicketSupportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket-support")
@RequiredArgsConstructor
public class TicketSupportController {

    private final TicketSupportService ticketSupportService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody TicketSupportModel model) {
        return ResponseEntity.ok(ticketSupportService.create(model));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketSupportService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<TicketSupportModel>> getListOfTickets(
            @PageableDefault(sort = "id",
                            direction = Sort.Direction.ASC
            ) Pageable pageable) {

        return ResponseEntity.ok(ticketSupportService.getListOfTickets(pageable));
    }

    @PostMapping("update-status/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestParam("status") TicketStatus status) {

        ticketSupportService.updateTicketStatus(id, status);
        return ResponseEntity.ok().build();
    }
}