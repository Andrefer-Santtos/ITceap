package br.com.secretary.itceap.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.secretary.itceap.beans.PredioS;
@Repository
public interface PredioSDAO extends CrudRepository<PredioS, Long> {

	PredioS findById(long id);
}