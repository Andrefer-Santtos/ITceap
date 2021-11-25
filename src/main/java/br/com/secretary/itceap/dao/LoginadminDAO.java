package br.com.secretary.itceap.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.secretary.itceap.beans.Loginadmin;
@Repository
public interface LoginadminDAO extends CrudRepository<Loginadmin, Long> {
	
	public Loginadmin findByEmailAndSenha(String email,String senha);
}