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

import com.claudiobraga.genesys.domain.repository.MessageRepository;

import io.restassured.http.ContentType;

@WebMvcTest
public class MessageControllerTest {
	
	@Autowired
	private MessageController messageController;
	
	@MockBean
	private MessageRepository messageRepository;
	
	@BeforeEach
	public void setup() {
		
		standaloneSetup(this.messageController);
	}
	
	@Test
	public void shouldReturnSuccess_WhenEditMessage() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.put("/messages")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldReturnSuccess_WhenGettingAllMessages() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/messages")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldReturnBadRequest_WhenDelettingMessage() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.delete("/messages/{id}", -1L)
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.messageRepository, never()).deleteById(-1L);
	}

}
