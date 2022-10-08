package com.samet.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // login işlemlerinde kullanılan controller
public class LoginController {

	@GetMapping("/showMyLoginPage")  // login  ekran uzantısının belirtilmesi
	public String showMyLoginPage() {
		
		return "fancy-login";  // login ekranının döndürülmesi
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")  // hatalı işlemlerde döndürülecek olan sayfa uzantısı
	public String showAccessDenied() {
		
		return "access-denied";  // hatalı işlemlerde dönecek sayfa
		
	}
	
}