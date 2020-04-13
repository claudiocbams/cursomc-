package com.claudio.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.claudio.cursomc.domain.Pedido;

public interface EmailService {
    void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	//void sendNewPasswordEmail(Cliente cliente, String newPass)

}
