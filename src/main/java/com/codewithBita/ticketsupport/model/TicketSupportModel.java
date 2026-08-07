package com.codewithBita.ticketsupport.model;

import com.codewithBita.ticketsupport.enums.TicketStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "TicketSupportModel")
@Getter
@Setter
public class TicketSupportModel {

    private Long id;
    // شناسه تیکت

    private String title;
    // عنوان تیکت

    private String description;
    // توضیحات

    private TicketStatus status = TicketStatus.OPEN;
    // وضعیت تیکت
}