package com.claudio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.claudio.cursomc.domain.Categoria;
import com.claudio.cursomc.domain.Produto;
import com.claudio.cursomc.repositories.CategoriaRepository;
import com.claudio.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
   @Autowired
	private CategoriaRepository categoriaRepository;
   
   @Autowired
	private ProdutoRepository produtoRepository;
   
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	@Override
	public void run(String ...args) throws Exception{
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 1000.00);
		Produto p3 = new Produto(null, "Mouse", 20.00);
		Produto p4 = new Produto(null, "Teclado", 40.00);
		Produto p5 = new Produto(null, "Caderno", 35.00);
		Produto p6 = new Produto(null, "Cadeira", 180.00);
		Produto p7 = new Produto(null, "Mesa", 400.00);
		cat1.getProdutos().addAll(Arrays.asList(p1, p2,p3,p4));
		cat2.getProdutos().addAll(Arrays.asList(p5, p6,p7));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat2));
		p6.getCategorias().addAll(Arrays.asList(cat2));
		p7.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		
		
	}

}
