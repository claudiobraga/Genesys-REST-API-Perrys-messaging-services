package com.claudiobraga.genesys.api.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.claudiobraga.genesys.domain.repository.UserRepository;

import io.restassured.http.ContentType;

@WebMvcTest
public class UserControllerTest {
	
	@Autowired
	private UserController userController;
	

	@MockBean
	private UserRepository userRepository;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.userController);
	}
	
	@Test
	public void shouldReturnCreated_WhenCreateUser() {
		
		given()
		.accept(ContentType.JSON)
	.when()
		.post("/users")
	.then()
		.statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	public void shouldReturnSuccess_WhenGetUsers() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/users")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldReturnNotFund_WhenGetUser() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/users/{id}", 10L)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void shouldReturnBadRequest_WhenGetUser() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/users/{id}", -6L)
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.userRepository, never()).getOne(-6L);
	}

}
