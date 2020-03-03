package com.SpringApplication.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootTest
@Profile("test")
@AutoConfigureTestDatabase
class DemoApplicationTests {

	@Test
	void contextLoads() {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "test");
	}

}
