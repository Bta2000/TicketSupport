package com.codewithBita.ticketsupport.entity;

import com.codewithBita.ticketsupport.enums.TicketStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ticket_support", schema = "support")
@Getter
@Setter
public class TicketSupportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;
    // عنوان تیکت

    @NotBlank
    @Column(name = "description", nullable = false, columnDefinition="TEXT")
    private String description;
    // توضیحات

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TicketStatus status = TicketStatus.OPEN;
    // وضعیت تیکت
}