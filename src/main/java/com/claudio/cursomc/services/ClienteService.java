package com.claudio.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.claudio.cursomc.domain.Cliente;
import com.claudio.cursomc.dto.ClienteDTO;
import com.claudio.cursomc.repositories.ClienteRepository;
import com.claudio.cursomc.services.exceptions.DataIntegrityException;
import com.claudio.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	/*
	public Cliente Buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null); 
	}
	*/
	
	public Cliente find(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		} 
	public Cliente Insert (Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possivel excluir esse cliente por que há entidadees relacionadas");
			
		}
	}
	
	public List<Cliente> findAll(){
		
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer pages, Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(pages, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) {
		 return new Cliente(objDTO.getId(),objDTO.getNome(),objDTO.getEmail(), null, null);
	}
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
		

}
