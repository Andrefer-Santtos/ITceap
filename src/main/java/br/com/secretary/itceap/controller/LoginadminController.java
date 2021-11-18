package br.com.secretary.itceap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretary.itceap.beans.Loginadmin;
import br.com.secretary.itceap.dao.LoginadminDAO;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LoginadminController {
	@Autowired
	private LoginadminDAO dao;

	@GetMapping("/login")
	public ResponseEntity<List<Loginadmin>> getAll() {

		List<Loginadmin> lista = (List<Loginadmin>) dao.findAll();

		if (lista.size() == 0) {

			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

	@PostMapping("/savelogin")
	public Loginadmin salvalogin(@RequestBody Loginadmin loginadmin) {
		return dao.save(loginadmin);
	}

	@DeleteMapping("/deletelogin")
	public void deletalogin(@RequestBody Loginadmin loginadmin) {
		dao.delete(loginadmin);
	}

	@PutMapping("/updatelogin")
	public Loginadmin atualizalogin(@RequestBody Loginadmin loginadmin) {
		return dao.save(loginadmin);
	}
}
