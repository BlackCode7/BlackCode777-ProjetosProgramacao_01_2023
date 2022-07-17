package com.blackcode3produto.Produto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackcode3produto.Produto.Services.ProdutoServices;
import com.blackcode3produto.Produto.Services.SMSServices;
import com.blackcode3produto.Produto.entities.Produto;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControllers {
	
	@Autowired
	private ProdutoServices produtoServices;
	
	@Autowired
	private SMSServices smsServices;
	
	@GetMapping
	public Page<Produto> findProdutos(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, 
			Pageable pageable ){
		
		return produtoServices.findProduto(minDate, maxDate, pageable);
		
	}
	
	@GetMapping("/{id}/notification")
	public void notifySMS( @PathVariable Long id ) {
		smsServices.sendSms(id);
	}

}






















