package academoy.devdojo.springboot2essencials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Springboot2EssencialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2EssencialsApplication.class, args);

		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}
}
