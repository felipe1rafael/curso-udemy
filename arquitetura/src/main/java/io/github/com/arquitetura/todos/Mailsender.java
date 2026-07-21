package io.github.com.arquitetura.todos;

import org.springframework.stereotype.Component;

@Component
public class Mailsender {
    public void enviar (String messagem){
        System.out.println("Enviado email:"+ messagem);


    }


}
