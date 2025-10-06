package com.devsenai1A.conversor.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorController {
	@PostMapping ("/converter")
	@ResponseBody
	public Map<String, Object> converterJson(
			@RequestParam double num1,
			@RequestParam String inicio,
			@RequestParam String fim){
		
				double resultado=0;
				String erro = null;
				
				switch(inicio) {
				case "farenheit":
					if(fim.equals("celsius"))
						resultado = (num1 - 32) * 5/9;
					else if (fim.equals("kelvin")) 
						resultado = (num1 - 32) * 5/9 + 273.15; 
					else 
						resultado = num1;
					break;
				case "celsius":
					if(fim.equals("farenheit"))
						resultado = (num1 * 1.8) + 32;
					 else if (fim.equals ("kelvin")) 
						 resultado = num1 + 273.15;
					 else 
						resultado = num1;
					break;
				case "kelvin":
					if(fim.equals("farenheit"))
						resultado = (num1 - 273.15) * 1.8 + 32;
					else if (fim.equals ("celsius"))
						resultado = num1 - 273.15; 
					else 
						resultado = num1;	
					break;
				default: erro = "Conversão inválida!";
				}
				
				Map<String, Object> resp = new HashMap<>();
				resp.put("resultado", resultado);
				resp.put("erro", erro);
				return resp;
	}
}
