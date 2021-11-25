package br.com.secretary.itceap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.secretary.itceap.beans.Loginadmin;
import br.com.secretary.itceap.dao.LoginadminDAO;

@Controller
@CrossOrigin("*")
public class LoginadminController {
	@Autowired
	private LoginadminDAO dao;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/loginadmin")
	public ResponseEntity<Loginadmin> login(@RequestBody Loginadmin objeto){
		Loginadmin resposta = dao.findByEmailAndSenha(objeto.getEmail(), objeto.getSenha());
		if(resposta == null) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(resposta);
		
	}
}
