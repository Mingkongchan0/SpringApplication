package com.SpringApplication.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication{
	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		SpringApplication.run(DemoApplication.class, args);
	}
}