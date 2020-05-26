package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insert(Libro libro) throws DataAccessException {
		entityManager.persist(libro);
		
	}

	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro> resultSet = query.getResultList();
		
		return resultSet;
	}

	/*
	@Override
	public Libro findOne(Integer c_categoria) throws DataAccessException {
		Libro libro = entityManager.find(Libro.class, c_categoria);
		return libro;
	}
	*/

}
