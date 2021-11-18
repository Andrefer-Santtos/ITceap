package br.com.secretary.itceap.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.secretary.itceap.beans.Itens;
@Repository
public interface ItensDAO extends CrudRepository<Itens, Long> {
	
	Itens findById(long id);
}