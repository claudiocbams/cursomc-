package com.claudio.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.claudio.cursomc.domain.Categoria;
import com.claudio.cursomc.repositories.CategoriaRepository;
import com.claudio.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	/*
	public Categoria Buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null); 
	}
	*/
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		} 
	
	public Categoria Insert (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		
		catch (DataIntegrityViolationException e) {
			
		}
	}
	
	public List<Categoria> findAll(){
		
		return repo.findAll();
	}

}
