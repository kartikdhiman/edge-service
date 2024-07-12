package com.polarbookshop.edgeservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class EdgeServiceApplicationTests {

	private static final int REDIS_PORT = 6379;

	@Container
	@ServiceConnection(name = "redis")
	static GenericContainer<?> redis =
					new GenericContainer<>("redis:7.2-alpine")
									.withExposedPorts(REDIS_PORT);

	@Test
	void connectionEstablished() {
		assertThat(redis.isRunning()).isTrue();
	}

	@Test
	void verifyThatSpringContextLoads() {
	}
}
