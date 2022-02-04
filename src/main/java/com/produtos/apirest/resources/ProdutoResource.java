package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.produtos.apirest.models.Produto;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
//@CrossOrigin(origins="*") sever para que qualquer dominio possa acessar este dominio, poderia ser: "http..."
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	//Testar com o Postman método GET: http://localhost:8080/api/produtos
	//retorna a lista de produtos do banco
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista e Produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	//Testar com o Postman método GET: http://localhost:8080/api/produto/1
	//retorna produto especifico do banco
	//criar o metodo "Produto findById(long id);" na classe "ProdutoRepository.java"
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna Produto unico")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	/*  no Postman na Headers na Key digitar "Content-Type" e em Value "application/json"
	 	Pra testar o POST ir na guia do Postman Body e opcao Raw e colar linhas abaixo 
	 {
	    "nome": "Arroz",
	    "quantidade": 2.00,
	    "valor": 15.00
	}
	    testar com metodo POST: http://localhost:8080/api/produto
	 */
	@PostMapping("/produto")
	@ApiOperation(value="Salva um Produtos")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	
	//@RequestBody seve para tratar informações como Json
	//para testar este metodo, no Postman na Headers na Key digitar "Content-Type" e em Value "application/json"
	//na guia Body usar: 
		/*
		 	{
			    "id": 2,
			    "nome": "Arroz",
			    "quantidade": 2.00,
			    "valor": 15.00
			}
		 */
	//na guia Body usar o metodo DELETE: http://localhost:8080/api/produto
	@DeleteMapping("/produto")
	@ApiOperation(value="Delata um Produtos")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	
	//para testar este metodo, no Postman na Headers na Key digitar "Content-Type" e em Value "application/json"
		//na guia Body usar: 
			/*
			 	{
				    "id": 1,
				    "nome": "Feijão",
				    "quantidade": 3.00,
				    "valor": 9.00
				}
			 */
		//na guia Body usar o metodo PUT: http://localhost:8080/api/produto
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um Produtos")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
