package io.github.com.arquitetura.montadora.api;

import io.github.com.arquitetura.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TestFabricaContontrolle {

    @Autowired //automitiza a instancia pelo bean MontadoraConfiguration
    @Qualifier("Eletrico") //escolha do bean
    private Motor motor;


    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
    var carro = new HondaHRV(motor);

    return carro.darInginicao(chave);
    }
}
