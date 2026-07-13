package io.github.com.arquitetura.montadora.configuration;

import io.github.com.arquitetura.montadora.Motor;
import io.github.com.arquitetura.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {




    @Bean (name = "Aspirado")
    public Motor motorAspirado (){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindors(4);
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        motor.setModelo("XPTO-0");
        return motor;
    }
    @Bean(name = "Eletrico")
    public Motor motorEletrico (){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindors(4);
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        motor.setModelo("TH10");
        return motor;

    }
    @Primary
    @Bean (name = "Turbo")
    public Motor motorTurbo (){
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindors(4);
        motor.setLitragem(1.5);
        motor.setTipo(TipoMotor.TURBO);
        motor.setModelo("XPTO-01");
        return motor;
    }
}
