package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	//aula 2: https://www.youtube.com/watch?v=LmqVHTOqcxs&list=PL8iIphQOyG-D2FP9wkg12AavzmVRWEcnJ&index=2
	
	Produto findById(long id);

}
