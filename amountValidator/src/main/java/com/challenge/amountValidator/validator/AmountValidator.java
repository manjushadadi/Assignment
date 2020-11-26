package com.challenge.amountValidator.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.challenge.amountValidator.enums.Frequency;
import com.challenge.amountValidator.model.RegularAmount;

public class AmountValidator implements ConstraintValidator<Amount, RegularAmount> {

	@Override
	public void initialize(Amount constraintAnnotation) {
	}

	@Override
	public boolean isValid(RegularAmount regularAmount, ConstraintValidatorContext context) {
		/*
		 * No validation when 
		 * Invalid Amount or Null Frequency or
		 *  Weekly or Monthly
		 */
		String regex = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
		if (!Pattern.compile(regex).matcher(regularAmount.getAmount()).find() 
				|| regularAmount.getFrequency() == null
				|| regularAmount.getFrequency().equals(Frequency.WEEK)
				|| regularAmount.getFrequency().equals(Frequency.MONTH)) {
			return true;
		}

		int noOfWeeks = getAssociatedWeeks(regularAmount.getFrequency());
		// Validated as valid when the amount is divided by weeks
		if (Double.parseDouble(regularAmount.getAmount()) % noOfWeeks == 0) {
			return true;
		}

		return false;

	}

	private int getAssociatedWeeks(Frequency frequency) {
		switch (frequency) {
		case TWO_WEEK:
			return 2;
		case FOUR_WEEK:
			return 4;
		case QUARTER:
			return 13;
		case YEAR:
			return 52;
		default:
			return 1;
		}

	}
}