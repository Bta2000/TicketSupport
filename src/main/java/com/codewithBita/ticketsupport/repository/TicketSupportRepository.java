package com.codewithBita.ticketsupport.repository;

import com.codewithBita.ticketsupport.entity.TicketSupportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketSupportRepository  extends JpaRepository<TicketSupportEntity, Long> {
}