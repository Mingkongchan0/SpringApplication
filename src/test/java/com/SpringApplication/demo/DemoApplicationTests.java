package com.SpringApplication.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("test")
@AutoConfigureTestDatabase
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
