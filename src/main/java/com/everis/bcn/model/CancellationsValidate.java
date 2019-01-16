package com.everis.bcn.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.everis.bcn.dto.CancelDto;

/***
 * 
 * @author J Michael
 *
 */
@Component
public class CancellationsValidate implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return CancelDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CancelDto cancellationDto = (CancelDto) obj;
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "day", "required.persons", "es olbigatorio indicar el día de la reserva");
//		if (cancellationDto.getDay() == null)  errors.rejectValue("day", "fecha de reserva no es válida");
		if (cancellationDto.getLocalizator() < 1)  errors.rejectValue("Localizator", "Localizator no es válido");
	}

}
