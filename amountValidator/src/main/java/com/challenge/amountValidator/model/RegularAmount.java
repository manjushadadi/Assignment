package com.challenge.amountValidator.model;

import com.challenge.amountValidator.enums.Frequency;
import com.challenge.amountValidator.validator.Amount;
import com.challenge.amountValidator.validator.ValidEnumValue;

@Amount
public class RegularAmount {
	@ValidEnumValue(regexp = "WEEK|TWO_WEEK|FOUR_WEEK|MONTH|QUARTER|YEAR")
	private Frequency frequency;
	
	private String amount;

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
