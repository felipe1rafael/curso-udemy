package io.github.com.arquitetura;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
public class ArquiteturaApplication {

	public static void main(String[] args) {

		//SpringApplication.run(ArquiteturaApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ArquiteturaApplication.class);
		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("producao", "homologacao");
		//builder.lazyInitialization(false);


		builder.run(args);

	}

}
