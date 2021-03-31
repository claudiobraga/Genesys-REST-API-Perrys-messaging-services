package com.claudiobraga.genesys.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.claudiobraga.genesys.domain.model.Message;
import com.claudiobraga.genesys.domain.repository.MessageRepository;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Message send(@Valid @RequestBody Message message) {
		return messageRepository.save(message);
	}
	
	@GetMapping()
	public List<Message> getMessages(){
		return messageRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Message> getById(@Valid @PathVariable Long id){
		Optional<Message> message = messageRepository.findById(id);
		
		if (message.isPresent()) {
			return ResponseEntity.ok(message.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Message> editMessage(@Valid @PathVariable Long id, @RequestBody Message message){
		if (!messageRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		message.setId(id);
		message = messageRepository.save(message);
		return ResponseEntity.ok(message);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteMsg(@PathVariable Long id){
		if (!messageRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		messageRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
