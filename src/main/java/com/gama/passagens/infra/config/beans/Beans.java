package com.gama.passagens.infra.config.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.amadeus.Amadeus;

@Configuration
public class Beans {
	@Value("${amadeus.id}")
	private String amadeusId;
	
	@Value("${amadeus.secret}")
	private String amadeusSecret;
	
	@Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
	@Bean
    public Amadeus amadeus(){
        return Amadeus
				.builder(amadeusId, amadeusSecret)
				.build();
    }
	/*
	@Bean(name="messageSource")
	public ResourceBundleMessageSource bundleMessageSource() {
	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	messageSource.setBasename("message");
	return messageSource;
	}
	*/
	@Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/message");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }
	
}
