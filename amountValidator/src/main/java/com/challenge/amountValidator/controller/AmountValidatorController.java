package com.challenge.amountValidator.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.amountValidator.model.RegularAmount;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AmountValidatorController {

	@PostMapping("/validateAmount")
	@ApiOperation(
	        value = "Validate the incomes from the regular amount submitted using JSR-303 custom annotation and returns true if valid",
	        notes = "Returns HTTP 400 if the amount is not valid and does not divide to the frequency (no of weeks) to a whole number",
	        response = String.class 
	)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "true"),
	        @ApiResponse(code =400,message="Invalid amount")
	})
	public ResponseEntity<?> validateAmount(@Valid @RequestBody RegularAmount regularAmount, Errors errors) {
		try {
			if(errors.hasErrors()){
				return new ResponseEntity<String>("Invalid amount", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
