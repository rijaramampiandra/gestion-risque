package mg.rija.gestion.risque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = { "mg.rija.gestion.risque" })
@PropertySource(value = { "classpath:default-config/application-default.properties" }, ignoreResourceNotFound = true)
public class GestionRisqueWebApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GestionRisqueWebApplication.class, args);
	}

}