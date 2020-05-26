package com.uca.capas.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroDAO libroDAO;
	
	@Autowired
	CategoriaService categoriaService;

	@Override
	@Transactional
	public void insert(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		Date f_ingreso = new Date();
		libro.setF_ingreso(f_ingreso);
		
		libro.setCategoria(categoriaService.findOne(libro.getC_categoria()));
		libroDAO.insert(libro);
	}

	@Override
	public List<Libro> findAll() throws DataAccessException {
		return libroDAO.findAll();
	}

}
