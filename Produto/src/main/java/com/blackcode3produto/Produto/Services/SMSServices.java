package com.blackcode3produto.Produto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.blackcode3produto.Produto.entities.Produto;
import com.blackcode3produto.Produto.repositories.ProdutoRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSServices {
	
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void sendSms( Long produtoId) {
				
		Produto produto = produtoRepository.findById(produtoId).get();		
		String date = produto.getDate().getMonth()+ "/" + produto.getDate().getYear();
		
		/* Parado no tempo 1:34min de vídeo */
		String msg = "Vendedor " + produto.getNomeVendedor() + " Foi destaque em " + date
				+ " Com um total de R$ " + String.format("%.2f", produto.getMontante()) ;
		
		Twilio.init(twilioSid, twilioKey);
		
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		
		Message message = Message.creator(to, from, msg).create();
		
		System.out.println(message.getSid());
		
	}

}








