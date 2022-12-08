package com.crewmeister.cmcodingchallenge.model.wrapper;

import java.util.UUID;

public class Message {

	private long timestamp;
	private String status;
	private String error;
	private String exception;
	private String message;
	private MessageType messageType;
	private String path;
	private UUID identifier;

	public Message(MessageType messageType, String message, long timestamp, String status, String error,
			String exception, String path) {
		this.message = message;
		this.messageType = messageType;
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.exception = exception;
		this.path = path;
		this.identifier = identifier;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public UUID getIdentifier() {
		return identifier;
	}

	public void setIdentifier(UUID identifier) {
		this.identifier = identifier;
	}
}
