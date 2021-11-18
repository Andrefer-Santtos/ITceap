package br.com.secretary.itceap.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.secretary.itceap.beans.PredioO;

@Repository
public interface PredioODAO extends CrudRepository<PredioO, Long> {
	
	PredioO findById(long id);
}