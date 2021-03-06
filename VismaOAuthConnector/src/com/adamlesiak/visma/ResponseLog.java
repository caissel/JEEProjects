package com.adamlesiak.visma;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Class for storing messages returned from HTTP response from Visma
 * 
 * @author Adam Lesiak <adamlesiak@adamlesiak.com>
 *
 */


public class ResponseLog {

	/**
	 * Status Code: 201
	 * Successfully created an object in Visma database
	 */
	public static final int HTTP_STATUS_CODE_CREATED = 201;
	
	/**
	 * Status Code: 400
	 * Unauthorized - error in authorization. Client ID or Client Secret invalid
	 */
	public static final int HTTP_STATUS_CODE_BAD_REQUEST = 400;
	
	/**
	 * Status Code: 401
	 * Unauthorized - error in authorization. Client ID or Client Secret invalid
	 */
	public static final int HTTP_STATUS_CODE_UNAUTHORIZED = 401;
	
	/**
	 * Status Code: 409
	 * Conflict - object with specified field (ID, Number depends on Visma object) existing
	 */
	public static final int HTTP_STATUS_CODE_CONFLICT = 409;

	
	/**
	 * Messages for HTTP statuses
	 */
	public static final String HTTP_STATUS_CODE_CREATED_MESSAGE = "The object has been successful exported.";
	public static final String HTTP_STATUS_CODE_BAD_REQUEST_MESSAGE = "Bad request. The sent request contains wrong fields or data.";
	public static final String HTTP_STATUS_CODE_UNAUTHORIZED_MESSAGE = "Authorization failed.";
	public static final String HTTP_STATUS_CODE_CONFLICT_MESSAGE = "Conflict. Export failed";
	
	
	private int statusCode;
	private String returnedId;	
	private String message;
	private String additionalMessage;
	private Map<Integer, String> messagesMap;
	
	/**
	 * 
	 * @param statusCode - HTTP status code
	 * @param returnedId - returned ID from Visma after successful insertion of object
	 */	
	public ResponseLog(int statusCode, String returnedId, String message, String additionalMessage) {
		this.statusCode = statusCode;
		this.returnedId = returnedId;
		this.message = message;
		this.additionalMessage = additionalMessage;
		createMessagesMap();
	}
	
	/**
	 * Gets message for specified status
	 */
	public String getHTTPStatusCodeMessage() {
		return messagesMap.get(statusCode);
	}
	
	
	/**
	 * Creates map for message
	 */
	private void createMessagesMap() {
		messagesMap = new HashMap<Integer, String>();
		messagesMap.put(HTTP_STATUS_CODE_CREATED, HTTP_STATUS_CODE_CREATED_MESSAGE);
		messagesMap.put(HTTP_STATUS_CODE_UNAUTHORIZED, HTTP_STATUS_CODE_UNAUTHORIZED_MESSAGE);
		messagesMap.put(HTTP_STATUS_CODE_CONFLICT, HTTP_STATUS_CODE_CONFLICT_MESSAGE);
		messagesMap.put(HTTP_STATUS_CODE_BAD_REQUEST, HTTP_STATUS_CODE_BAD_REQUEST_MESSAGE);
	}
	
	
	/**
	 * Getters and setters
	 * 
	 */
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
		
	public String getReturnedId() {
		return returnedId;
	}
	public void setReturnedId(String returnedId) {
		this.returnedId = returnedId;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAdditionalMessage() {
		return additionalMessage;
	}

	public void setAdditionalMessage(String additionalMessage) {
		this.additionalMessage = additionalMessage;
	}
	
	
		
}
