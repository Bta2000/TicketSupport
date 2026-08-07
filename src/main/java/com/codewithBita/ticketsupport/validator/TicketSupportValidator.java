package com.codewithBita.ticketsupport.validator;

import com.codewithBita.ticketsupport.exception.BindingException;
import com.codewithBita.ticketsupport.model.TicketSupportModel;
import com.codewithBita.ticketsupport.util.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketSupportValidator {

    private final MessageUtil messageUtil;


    public void validate(TicketSupportModel model) {

        BindingException bindingException = new BindingException();

        necessaryFieldValidate(model, bindingException);

        if (!bindingException.getErrors().isEmpty()) {
            throw bindingException;
        }
    }

    public void necessaryFieldValidate(TicketSupportModel model, BindingException bindingException) {

        if (model.getTitle() == null || model.getTitle().isBlank()) {

            bindingException.addError("ERROR",
                    messageUtil.getMessage("TicketTitleIsNecessary")
            );
        }

        if (model.getDescription() == null || model.getDescription().isBlank()) {

            bindingException.addError("ERROR",
                    messageUtil.getMessage("DescriptionIsNecessary")
            );
        }
    }
}