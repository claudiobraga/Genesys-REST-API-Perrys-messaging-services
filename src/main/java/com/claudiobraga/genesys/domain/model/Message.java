package com.claudiobraga.genesys.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String messageContent;
	
	@NotNull
	private String userSending;
	
	@NotNull
	private String userReceiving;
	
	private LocalDate dateOfSent;
	
	private LocalDate dateOfReception;
	
	private String messageStatus;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getUserSending() {
		return userSending;
	}

	public void setUserSending(String userSending) {
		this.userSending = userSending;
	}

	public String getUserReceiving() {
		return userReceiving;
	}

	public void setUserReceiving(String userReceiving) {
		this.userReceiving = userReceiving;
	}

	public LocalDate getDateOfSent() {
		return dateOfSent;
	}

	public void setDateOfSent(LocalDate dateOfSent) {
		this.dateOfSent = dateOfSent;
	}

	public LocalDate getDateOfReception() {
		return dateOfReception;
	}

	public void setDateOfReception(LocalDate dateOfReception) {
		this.dateOfReception = dateOfReception;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(id, other.id);
	}

}
