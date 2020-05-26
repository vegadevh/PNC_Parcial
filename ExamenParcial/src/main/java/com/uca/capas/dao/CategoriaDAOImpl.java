package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insert(Categoria categoria) throws DataAccessException {
		entityManager.persist(categoria);
		
	}

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria> resultSet = query.getResultList();
		
		return resultSet;
	}

	@Override
	public Categoria findOne(Integer c_categoria) throws DataAccessException {
		Categoria categoria = entityManager.find(Categoria.class, c_categoria);
		return categoria;
	}

}
