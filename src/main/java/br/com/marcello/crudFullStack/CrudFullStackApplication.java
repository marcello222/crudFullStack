package br.com.marcello.crudFullStack;

import br.com.marcello.crudFullStack.domain.Categoria;
import br.com.marcello.crudFullStack.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CrudFullStackApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudFullStackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "informatica");
		Categoria categoria2 = new Categoria(null, "escritório");

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
	}
}
