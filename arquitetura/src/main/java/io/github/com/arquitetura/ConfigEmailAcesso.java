package io.github.com.arquitetura;

import io.github.com.arquitetura.todos.Mailsender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigEmailAcesso {

    @Autowired
    private AppProperties properties;

    //@Bean
    public Mailsender mailsender(){
        return  null;
    }
}
