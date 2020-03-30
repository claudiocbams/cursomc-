package com.claudio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.claudio.cursomc.domain.Categoria;
import com.claudio.cursomc.domain.Cidade;
import com.claudio.cursomc.domain.Estado;
import com.claudio.cursomc.domain.Produto;
import com.claudio.cursomc.repositories.CategoriaRepository;
import com.claudio.cursomc.repositories.CidadeRepository;
import com.claudio.cursomc.repositories.EstadoRepository;
import com.claudio.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
   @Autowired
	private CategoriaRepository categoriaRepository;
   
   @Autowired
	private ProdutoRepository produtoRepository;
   @Autowired
  	private CidadeRepository cidadeRepository;
     
   @Autowired
  	private EstadoRepository estadoRepository;
     
   
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
		Estado est1 = new Estado(null,"MT");
		Estado est2 = new Estado(null,"MS");
		Estado est3 = new Estado(null,"RO");
		Estado est4 = new Estado(null,"RR");
		Estado est5 = new Estado(null,"RS");
		Estado est6 = new Estado(null,"MG");
		
		Cidade c1 = new Cidade(null, "Cuiabá", est1);
		Cidade c2 = new Cidade(null, "Porto Velho", est3);
		Cidade c3 = new Cidade(null, "Campo Grande", est2);
		Cidade c4 = new Cidade(null, "Porto Alegre", est5);
		Cidade c5 = new Cidade(null, "Belo Horizonte", est6);
		Cidade c6 = new Cidade(null, "Uberlândia", est6);
		Cidade c7 = new Cidade(null, "Boa Vista", est4);
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c3));
		est3.getCidades().addAll(Arrays.asList(c2));
		est4.getCidades().addAll(Arrays.asList(c7));
		est5.getCidades().addAll(Arrays.asList(c4));
		est6.getCidades().addAll(Arrays.asList(c5,c6));
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		estadoRepository.saveAll(Arrays.asList(est1,est2, est3, est4, est4, est5, est6));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));
		
		
	}

}
