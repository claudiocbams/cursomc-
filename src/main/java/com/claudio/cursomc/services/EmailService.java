package com.claudio.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.claudio.cursomc.domain.Cliente;
import com.claudio.cursomc.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail(Pedido obj);

	void sendOrderConfirmationHtmlEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

	void sendHtmlEmail(MimeMessage msg);
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
