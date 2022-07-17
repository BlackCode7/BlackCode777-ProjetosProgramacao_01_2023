package com.blackcode3produto.Produto.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blackcode3produto.Produto.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("SELECT obj FROM Produto obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.montante DESC")
	Page<Produto> findProdutos(LocalDate min, LocalDate max, Pageable pageable);

	
}
