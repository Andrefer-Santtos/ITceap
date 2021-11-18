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

import br.com.secretary.itceap.beans.PredioC;
import br.com.secretary.itceap.dao.PredioCDAO;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PredioCController {
	@Autowired
	private PredioCDAO dao;

	@GetMapping("/predioc")
	public ResponseEntity<List<PredioC>> getAll() {

		List<PredioC> lista = (List<PredioC>) dao.findAll();

		if (lista.size() == 0) {

			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/predioc/{id}")
	public PredioC listaPredioUnico(@PathVariable(value = "id") long id) {
		return dao.findById(id);
	}

	@PostMapping("/savepredioc")
	public PredioC salvaPredio(@RequestBody PredioC predioC) {
		return dao.save(predioC);
	}

	@DeleteMapping("/deletepredioc")
	public void deletaPredio(@RequestBody PredioC predioC) {
		dao.delete(predioC);
	}

	@PutMapping("/updatepredioc")
	public PredioC atualizaPredio(@RequestBody PredioC predioC) {
		return dao.save(predioC);
	}
}
