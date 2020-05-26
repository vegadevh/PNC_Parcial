package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_libro;
	
	@Size(message="El campo sobrepasa la cantidad de 150 caracteres", max=150)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="s_titulo")
	private String s_titulo;
	
	@Size(message="El campo sobrepasa la cantidad de 150 caracteres", max=150)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="s_autor")
	private String s_autor;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer c_categoria;
	
	@Temporal(TemporalType.DATE)
	@Column(name="f_ingreso")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date f_ingreso;
	
	@NotNull
	@Column(name="b_estado", nullable= false)
	private Boolean b_estado;
	
	@Size(message="El campo sobrepasa la cantidad de 10 caracteres", max=10)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="s_isbn")
	private String s_isbn;
	
	public Libro() {
		
	}
	//DELEGATE
	public String getEstadoDelegate() {
		if(this.b_estado==null) return "";
		else {
			return b_estado == true ? "Activo":"Inactivo";
		}
	}

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public Date getF_ingreso() {
		return f_ingreso;
	}

	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}

}
