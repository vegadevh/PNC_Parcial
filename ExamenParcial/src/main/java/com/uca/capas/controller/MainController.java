package com.uca.capas.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping("/index")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/categoria")
	public ModelAndView categoria() {
		ModelAndView mav = new ModelAndView();
		
		
		
		Categoria categoria = new Categoria();
		
		mav.addObject("categoria",categoria);
		mav.setViewName("/categoria");
		
		return mav;
	}
	
	//validarCategoria
	@RequestMapping("/validarCategoria")
	public ModelAndView validarCat(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("categoria");
		}else {
			categoriaService.insert(categoria);
			categoria = new Categoria();
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/libro")
	public ModelAndView libro() {
		ModelAndView mav = new ModelAndView();
		
		Libro libro = new Libro();
		List<Categoria> categorias = categoriaService.findAll();
		
		mav.addObject("categorias", categorias);
		mav.addObject("libro", libro);
		mav.setViewName("libro");
		
		return mav;
	}
	
	//ValidarLibro
	@RequestMapping("/validarLibro")
	public ModelAndView validarCat(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			List<Categoria> categorias = null;
			categorias=categoriaService.findAll();
			mav.addObject("categorias",categorias);
			mav.setViewName("libro");
		}else {
			libroService.insert(libro);
			libro = new Libro();
			mav.setViewName("index");
		}
		return mav;
	}
}
