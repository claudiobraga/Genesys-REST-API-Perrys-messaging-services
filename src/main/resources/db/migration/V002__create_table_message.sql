CREATE TABLE message(
	id BIGINT NOT NULL AUTO_INCREMENT,
	message_content TEXT,
	user_Sending BIGINT NOT NULL,
	user_Receiving BIGINT NOT NULL,
	date_Of_Sent DATETIME,
	date_Of_Reception DATETIME,
	message_Status VARCHAR(6),
	
	PRIMARY KEY (id)
);