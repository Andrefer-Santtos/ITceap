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

import br.com.secretary.itceap.beans.Itens;
import br.com.secretary.itceap.dao.ItensDAO;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ItensController {
	@Autowired
	private ItensDAO dao;

	@GetMapping("/itens")
	public ResponseEntity<List<Itens>> getAll() {

		List<Itens> lista = (List<Itens>) dao.findAll();

		if (lista.size() == 0) {

			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/itens/{id}")
	public Itens listaItensUnico(@PathVariable(value = "id") long id) {
		return dao.findById(id);
	}

	@PostMapping("/saveitens")
	public Itens salvaItens(@RequestBody Itens itens) {
		return dao.save(itens);
	}

	@DeleteMapping("/deleteitens")
	public void deletaItens(@RequestBody Itens itens) {
		dao.delete(itens);
	}

	@PutMapping("/updateitens")
	public Itens atualizaItens(@RequestBody Itens itens) {
		return dao.save(itens);
	}
}
