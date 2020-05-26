package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Libro;

public interface LibroDAO {
	
	public void insert(Libro libro) throws DataAccessException;
	
	public List<Libro> findAll() throws DataAccessException;

	//public Libro findOne(Integer c_categoria) throws DataAccessException;
}
