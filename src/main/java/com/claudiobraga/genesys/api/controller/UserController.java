package com.claudiobraga.genesys.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.claudiobraga.genesys.domain.model.Message;
import com.claudiobraga.genesys.domain.model.User;
import com.claudiobraga.genesys.domain.repository.MessageRepository;
import com.claudiobraga.genesys.domain.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping()
	public List<User> listUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUser(@Valid @PathVariable Long id){
		Optional<User> user = userRepository.findById(id);
		
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/other-users-that-have-sent-or-received-messages-to/from-a-specified-user")  
	public List<User> otherUsersSentOrReceivedMessages(){		
		List<User> allOtherUsers = new ArrayList<>();
		
		for(User user: userRepository.findAll()) {
			for(Message message: messageRepository.findAll()) {
				if(message.getUserSending().equalsIgnoreCase(user.getId()+"") ||
						message.getUserReceiving().equalsIgnoreCase(user.getId()+"")) {
					allOtherUsers.add(user);
				}
			}
		}
		
		return allOtherUsers;
	}

}
