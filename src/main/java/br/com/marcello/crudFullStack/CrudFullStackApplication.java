package br.com.marcello.crudFullStack;

import br.com.marcello.crudFullStack.domain.Categoria;
import br.com.marcello.crudFullStack.domain.Produto;
import br.com.marcello.crudFullStack.repository.CategoriaRepository;
import br.com.marcello.crudFullStack.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CrudFullStackApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudFullStackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "informatica");
		Categoria categoria2 = new Categoria(null, "escritório");

		Produto produto1 = new Produto(null, "computador", 2000.00);
		Produto produto2 = new Produto(null, "impressora", 800.00);
		Produto produto3 = new Produto(null, "mouse", 80.00);

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
	}
}
