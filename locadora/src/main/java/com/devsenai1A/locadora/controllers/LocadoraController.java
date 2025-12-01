package com.devsenai1A.locadora.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocadoraController {
	
	@PostMapping("/locar")
	@ResponseBody 
	
	public Map <String, Object> locarJson (
			@RequestParam String login,
			@RequestParam String senha){
		
		String resultado = null;
		String erro = null;
		
		String login1 = "joao@email.com";
		String senha1 = "123.456.789-00";
		
		
		if (login.equals(login1)) {
		} else {
			erro = "erro";
		} if (senha.equals(senha1)) {
				resultado = ("Logado com sucesso!");
		} else {
			erro = ("Usuário ou senha incorretos");
		}
		
		Map <String, Object> resp = new HashMap<>();
		resp.put("resultado", resultado);
		resp.put("erro", erro);
		return resp;
		
	}

}
