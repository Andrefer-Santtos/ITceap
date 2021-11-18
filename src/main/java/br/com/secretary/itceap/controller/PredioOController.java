package br.com.secretary.itceap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretary.itceap.beans.PredioO;
import br.com.secretary.itceap.dao.PredioODAO;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PredioOController {
	@Autowired
	private PredioODAO dao;

	@GetMapping("/predioo")
	public ResponseEntity<List<PredioO>> getAll() {

		List<PredioO> lista = (List<PredioO>) dao.findAll();

		if (lista.size() == 0) {

			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/predioo/{id}")
	public PredioO listaPredioUnico(@PathVariable(value = "id") long id) {
		return dao.findById(id);
	}

	@PostMapping("/savepredioo")
	public PredioO salvaPredio(@RequestBody PredioO predioO) {
		return dao.save(predioO);
	}

	@DeleteMapping("/deletepredioo")
	public void deletaPredio(@RequestBody PredioO predioO) {
		dao.delete(predioO);
	}

	@PutMapping("/updatepredioo")
	public PredioO atualizaPredio(@RequestBody PredioO predioO) {
		return dao.save(predioO);
	}
}
