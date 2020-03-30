package com.claudio.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claudio.cursomc.domain.Categoria;
import com.claudio.cursomc.services.CategoriaService;

@RestController
@RequestMapping(path= "/categorias")
public class CategoriaResources {
	@Autowired
	private CategoriaService service;
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.Buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
