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

import br.com.secretary.itceap.beans.PredioS;
import br.com.secretary.itceap.dao.PredioSDAO;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PredioSController {
	@Autowired
	private PredioSDAO dao;

	@GetMapping("/predios")
	public ResponseEntity<List<PredioS>> getAll() {

		List<PredioS> lista = (List<PredioS>) dao.findAll();

		if (lista.size() == 0) {

			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/predios/{id}")
	public PredioS listaPredioUnico(@PathVariable(value = "id") long id) {
		return dao.findById(id);
	}

	@PostMapping("/savepredios")
	public PredioS salvaPredio(@RequestBody PredioS predioS) {
		return dao.save(predioS);
	}

	@DeleteMapping("/deletepredios")
	public void deletaPredio(@RequestBody PredioS predioS) {
		dao.delete(predioS);
	}

	@PutMapping("/updatepredios")
	public PredioS atualizaPredio(@RequestBody PredioS predioS) {
		return dao.save(predioS);
	}
}
