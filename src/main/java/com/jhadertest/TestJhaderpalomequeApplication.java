package com.jhadertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {/*EmbeddedServletContainerAutoConfiguration.class, */WebMvcAutoConfiguration.class})
public class TestJhaderpalomequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJhaderpalomequeApplication.class, args);
	}

}
// Add the controller.
@RestController
class HelloWorldController {
	@GetMapping("/")
	public String hello() {
		return "welcome to zanser portal demo";
	}
}
