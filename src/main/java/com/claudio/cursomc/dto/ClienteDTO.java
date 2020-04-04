package com.claudio.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.claudio.cursomc.domain.Cliente;

public class ClienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message= "Preechimento Obrigatório")
	@Length(min = 5,max=80, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	@NotEmpty(message= "Preechimento Obrigatório")
	@Email(message= "Email Inválido!")
	private String email;
	
	public ClienteDTO() {
		
	}
	
	/// metodo para passar mensagem de categoria para categoria dto
	public ClienteDTO(Cliente obj) {
		
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
