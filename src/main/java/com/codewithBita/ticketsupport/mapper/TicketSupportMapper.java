package com.codewithBita.ticketsupport.mapper;

import org.mapstruct.Mapper;
import com.codewithBita.ticketsupport.entity.TicketSupportEntity;
import com.codewithBita.ticketsupport.model.TicketSupportModel;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface TicketSupportMapper {

    TicketSupportModel entityToModel(TicketSupportEntity entity);

    TicketSupportEntity modelToEntity(TicketSupportModel model);
}