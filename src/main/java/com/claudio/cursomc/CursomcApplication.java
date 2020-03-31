package com.claudio.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.claudio.cursomc.domain.Categoria;
import com.claudio.cursomc.domain.Cidade;
import com.claudio.cursomc.domain.Cliente;
import com.claudio.cursomc.domain.Endereco;
import com.claudio.cursomc.domain.Estado;
import com.claudio.cursomc.domain.Pagamento;
import com.claudio.cursomc.domain.PagamentoComBoleto;
import com.claudio.cursomc.domain.PagamentoComCartao;
import com.claudio.cursomc.domain.Pedido;
import com.claudio.cursomc.domain.Produto;
import com.claudio.cursomc.domain.enums.EstadoPagamento;
import com.claudio.cursomc.domain.enums.TipoCliente;
import com.claudio.cursomc.repositories.CategoriaRepository;
import com.claudio.cursomc.repositories.CidadeRepository;
import com.claudio.cursomc.repositories.ClienteRepository;
import com.claudio.cursomc.repositories.EnderecoRepository;
import com.claudio.cursomc.repositories.EstadoRepository;
import com.claudio.cursomc.repositories.PagamentoRepository;
import com.claudio.cursomc.repositories.PedidoRepository;
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
   
   @Autowired
 	private ClienteRepository clienteRepository;
  @Autowired
	private EnderecoRepository enderecoRepository;
  @Autowired
	private PedidoRepository pedidoRepository;
@Autowired
	private PagamentoRepository pagamentoRepository;
   
     
   
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
		
		Cliente cli1 = new Cliente(null, "Maria socorro","maria@gmail.com", "544.592.984-11", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("6732270683", "6999845522"));
		Cliente cli2 = new Cliente(null, "carlos","carlos@gmail.com", "644.592.982-09", TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("6632255583", "6999445523"));
		Cliente cli3 = new Cliente(null, "Marcola","marcolino@gmail.com", "474.592.984-15", TipoCliente.PESSOAFISICA);
		cli3.getTelefones().addAll(Arrays.asList("6833212383", "6999865526"));
		Cliente cli4 = new Cliente(null, "Marcolino","marcola@gmail.com", "354.592.984-10", TipoCliente.PESSOAJURIDICA);
		cli4.getTelefones().addAll(Arrays.asList("6932270683", "6999845545"));
		Cliente cli5 = new Cliente(null, "Marcelo","marcelino@gmail.com", "244.592.984-16", TipoCliente.PESSOAJURIDICA);
		cli5.getTelefones().addAll(Arrays.asList("6932377683", "6998845596"));
		
		Endereco end1 = new Endereco(null, "Rua São Paulo","453", "Condominio Aquarius", "Planalto", "76845-011",cli1, c2);
		Endereco end2 = new Endereco(null, "Rua São joão","7773", "Condominio Azaleia", "Madeireira", "79290-071",cli1, c1);
		Endereco end3 = new Endereco(null, "Av São José","77", "Condominio Amarilis", "Rio Madeira", "76875-021",cli3, c3);
		Endereco end4 = new Endereco(null, "Rua São sebastião","9978", "Condominio Rio Madeira", "Lixeira", "77845-251",cli4, c4);
		Endereco end5 = new Endereco(null, "Rua Rio de janeiro","73", "Condominio Rio Santos", "Paigauas", "78535-031",cli5, c6);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		cli3.getEnderecos().addAll(Arrays.asList(end3));
		cli3.getEnderecos().addAll(Arrays.asList(end4));
		cli3.getEnderecos().addAll(Arrays.asList(end5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		estadoRepository.saveAll(Arrays.asList(est1,est2, est3, est4, est4, est5, est6));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5));
		enderecoRepository.saveAll(Arrays.asList(end1,end2,end3,end4,end5));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/03/2020 17:00"),cli1,end1);
		Pedido ped2 = new Pedido(null,sdf.parse("29/03/2020 10:00"),cli1,end2);
		Pedido ped3 = new Pedido(null,sdf.parse("28/03/2020 11:00"),cli3,end3);
		Pedido ped4 = new Pedido(null,sdf.parse("25/03/2020 13:00"),cli4,end4);
		Pedido ped5 = new Pedido(null,sdf.parse("27/03/2020 16:00"),cli5,end5);
		
		
		Pagamento pg1 = new  PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6 );
		ped1.setPagamento(pg1);
		
		Pagamento pg2 = new  PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("28/03/2020 15:20"), null);
		ped2.setPagamento(pg2);
		Pagamento pg3 = new  PagamentoComBoleto(null, EstadoPagamento.QUITADO, ped3, sdf.parse("30/03/2020 15:20"), null );
		ped3.setPagamento(pg3);
		Pagamento pg4 = new  PagamentoComCartao(null, EstadoPagamento.QUITADO, ped4, 6 );
		ped4.setPagamento(pg4);
		Pagamento pg5 = new  PagamentoComCartao(null, EstadoPagamento.QUITADO, ped5, 6 );
		ped5.setPagamento(pg5);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		cli3.getPedidos().addAll(Arrays.asList(ped3));
		cli4.getPedidos().addAll(Arrays.asList(ped4));		
		cli5.getPedidos().addAll(Arrays.asList(ped5));
		
		
		
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2,ped3,ped4));
		pagamentoRepository.saveAll(Arrays.asList(pg1,pg2,pg3,pg4,pg5));
	}

}
