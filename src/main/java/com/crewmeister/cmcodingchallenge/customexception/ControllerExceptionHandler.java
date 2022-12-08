package com.crewmeister.cmcodingchallenge.customexception;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.crewmeister.cmcodingchallenge.model.wrapper.Message;
import com.crewmeister.cmcodingchallenge.model.wrapper.MessageType;



public class ControllerExceptionHandler {

	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	/** The logger. */
	private Logger logger = LogManager.getLogger(ControllerExceptionHandler.class.getName());

	/** The Constant VALIDATION_ERROR. */
	private static final String VALIDATION_ERROR = "Validation Error";

	/**
	 * Instantiates a new controller exception handler.
	 *
	 * @param messageSource the message source
	 */
	@Autowired
	public ControllerExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * Handle validation failure.
	 *
	 * @param request                      the request
	 * @param constarintViolationException the constarint violation exception
	 * @return the message
	 */
	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Message handleValidationFailure(HttpServletRequest request,
			ConstraintViolationException constarintViolationException) {

		StringBuilder messages = new StringBuilder();
		String message = "";

		if (constarintViolationException != null) {
			for (ConstraintViolation<?> violation : constarintViolationException.getConstraintViolations()) {
				Locale currentLocale = LocaleContextHolder.getLocale();
				messages.append(messageSource.getMessage(violation.getMessage(), null, currentLocale) + ", ");
			}

			if (messages.lastIndexOf(",") >= 0) {
				message = messages.toString().substring(0, messages.lastIndexOf(","));
			}

		}

		logger.error("", constarintViolationException);
		return ConstructMessage(MessageType.ERROR, message, System.currentTimeMillis(),
				String.valueOf(HttpStatus.BAD_REQUEST.value()), VALIDATION_ERROR,
				ConstraintViolationException.class.getName(),
				request.getRequestURI().substring(request.getContextPath().length()), constarintViolationException);
	}

	/**
	 * Construct message.
	 *
	 * @param messageType        the message type
	 * @param message            the message
	 * @param timestamp          the timestamp
	 * @param status             the status
	 * @param error              the error
	 * @param exceptionClassName the exception class name
	 * @param path               the path
	 * @param exception          the exception
	 * @return the message
	 */
	private Message ConstructMessage(MessageType messageType, String message, long timestamp, String status,
			String error, String exceptionClassName, String path, Exception exception) {
		return new Message(messageType, message, timestamp, status, error, exceptionClassName, path
				);

	}
}
