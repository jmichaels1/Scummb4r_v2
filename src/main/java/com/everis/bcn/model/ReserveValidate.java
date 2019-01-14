package com.everis.bcn.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.everis.bcn.dto.BookingDto;


/**
 * 
 * @author J Michael
 *
 */
@Component
public class ReserveValidate implements Validator {
	
	@Override
	public boolean supports(Class<?> type) {
		return BookingDto.class.isAssignableFrom(type);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		BookingDto reserveDto = (BookingDto) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "day", "required.persons", "es olbigatorio indicar el día de la reserva");
		if (reserveDto.getDay() == null)  errors.rejectValue("day", "fecha de reserva no es válida");
		if (reserveDto.getPersons() < 1)  errors.rejectValue("persons", "Cantidad de Personas para la reserva no es válido");
	}
}
