package br.com.secretary.itceap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
@CrossOrigin("*")
public class PredioCController {
	@Autowired
	private PredioCDAO dao;

	@GetMapping("/predioc")
	public String getAll(Model model) {

		ArrayList<PredioC> lista = (ArrayList<PredioC>) dao.findAll();
		model.addAttribute("predios", lista);
		
		return "tabela";
	}

	@GetMapping("/predioc/{id}")
	public ResponseEntity<List<PredioC>> listaPredioUnico(@PathVariable(value = "id") long id) {
		
		List<PredioC> response = (List<PredioC>) dao.findById(id);
		
		if(response == null) {
			
			return ResponseEntity.status(404).build();
			
		}
		
		return ResponseEntity.ok(response);
	}

	@PostMapping("/savepredioc")
	public ResponseEntity<PredioC> salvaPredio(@RequestBody PredioC predioC) {
		try {
			
			dao.save(predioC);
			return ResponseEntity.ok(predioC);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
		
	}

	@DeleteMapping("/deletepredioc")
	public ResponseEntity<PredioC> deletaPredio(@RequestBody PredioC predioC) {
		try {
			
			dao.delete(predioC);
			return ResponseEntity.ok(predioC);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
		
	}

	@PutMapping("/updatepredioc")
	public ResponseEntity<PredioC> atualizaPredio(@RequestBody PredioC predioC) {
		try {
			
			dao.save(predioC);
			return ResponseEntity.ok(predioC);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
		
	}
}
