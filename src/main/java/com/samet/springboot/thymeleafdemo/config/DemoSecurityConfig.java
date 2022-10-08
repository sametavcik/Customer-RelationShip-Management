package com.samet.springboot.thymeleafdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration // config olduğunu belirtiyoruz
@EnableWebSecurity // güvenlik configi olduğunu söylüyoruz işaretliyoruz
public class DemoSecurityConfig  {
	

	@Autowired  // field dependecy injection
	@Qualifier("securityDataSource") // DataSource binding önceliği için securityDataSource datasource'un kullanılması
	private DataSource securityDataSource;


	@Bean
	public UserDetailsManager userDetailsManager() {  // dataSourceyi jdbcusermanagere veriyoruz ve böylelikle kontrolü kendi yapıyor
		return new JdbcUserDetailsManager(securityDataSource); // entitymanager gibi kendi manageri var
		// db deki şifrelerde noop bunun encryptosuz olduğunu belirtir crypto koyulmazsa security izin vermez dolayısıyla noop koyarak devre dışı bırakıoz
		// databaseye {bcrypt} ile şifrelenmiş şifreler verildi böylelikle loginde verilen şifre bcrypte çevrilerek database deki bcryptle karşılaştırılır
		
	}
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // rol dağıtımı ve login logout işlemlerinin atandığı fonksiyon
	    		
	        return http
			.authorizeRequests(configurer ->  // herhangi bir sayfa için authenticated gerektiğini söyler
				configurer
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN"))
			
			.formLogin(configurer ->
				configurer
					.loginPage("/showMyLoginPage")  // başlangıçtaki default login formu kaldırıp kendi urlmizi verdik 
					.loginProcessingUrl("/authenticateTheUser") // springing doğrulama filtresine yönelendime yaptık burada doğrulama için ek koda gerek yok
					.permitAll()) // herkese gösterdik 
			.logout(configurer ->  // çıkış yapınca url vermeye gerek yok actiona /logout yapmak yeterli! doğrulamayı yaptığı yere dönüyor
			configurer
				.permitAll()) // herkese gösterdik 
			.exceptionHandling(configurer ->  //hatalı parola
			configurer
				.accessDeniedPage("/acces-denied")) // acces denied page'in gösterilmesi

			.build();  
	    }	
	 
	 
	 
	  
	
	
	
}







