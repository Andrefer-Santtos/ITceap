package br.com.secretary.itceap.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.secretary.itceap.beans.PredioC;

@Repository
public interface PredioCDAO extends CrudRepository<PredioC, Long> {
	
	PredioC findById(long id);
}