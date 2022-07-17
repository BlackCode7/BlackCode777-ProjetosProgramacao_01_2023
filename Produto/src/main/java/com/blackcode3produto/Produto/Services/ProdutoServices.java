package com.blackcode3produto.Produto.Services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blackcode3produto.Produto.entities.Produto;
import com.blackcode3produto.Produto.repositories.ProdutoRepository;



@Service
public class ProdutoServices {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Page<Produto> findProduto( String minDate, String maxDate, Pageable pageable ){
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max =  maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return produtoRepository.findProdutos(min, max, pageable);
		
	}
	
}
