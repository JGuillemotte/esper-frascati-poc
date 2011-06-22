package com.openwide.easysoa.monitoring;

import java.net.URL;
import javax.servlet.http.HttpServletRequest;

public class Message {

	/**
	 *	Message types 
	 */
	public enum MessageType {
	    WSDL, REST, SOAP 
	}

	private String protocol;
	private String host;
	private int port;
	private String pathName;
	private String parameters;
	private String content;
	private String method;
	private MessageType type;
	private String url;
	private String body;

	/**
	 * Initialize a new message
	 * @param request The HttpServletRequest
	 */
	public Message(HttpServletRequest request){
		this.pathName = request.getRequestURI();
		this.parameters = request.getQueryString();
		this.host = request.getServerName();
		this.port = request.getServerPort();
		if(request.getProtocol().toLowerCase().contains("http")){
			this.protocol = "http";
		} else {
			this.protocol = request.getProtocol();
		}
		this.method = request.getMethod();
		this.content = "";
		this.body = "";
		this.url = request.getRequestURL().toString();
	}
	
	/**
	 * Constructor
	 * @param host
	 * @param port
	 * @param pathName
	 * @param parameters
	 */
	public Message(String url, String protocol, String host, int port, String pathName, String parameters, MessageType type){
		this.url = url;
		if(protocol.toLowerCase().contains("http")){
			this.protocol = "http";
		} else {
			this.protocol = protocol;
		}
		this.host = host;
		this.port = port;
		this.pathName = pathName;
		this.parameters = parameters;
		this.type = type;
		this.content = "";
		this.method = "";
		this.body = "";
	}
	
	/**
	 * Constructor
	 * @param url Url
	 * @param type Type
	 */
	public Message(URL url, MessageType type) {
		this(url.toString(), url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), type);
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @return
	 */
	public String getParameters(){
		if(parameters == null){
			parameters = "";
		}
		return parameters;
	}

	/**
	 * 
	 * @return
	 */
	public String getHost() {
		if(host == null){
			host = "";
		}		
		return host;
	}

	/**
	 * 
	 * @return
	 */
	public String getPathName() {
		if(pathName == null){
			pathName = "";
		}
		return pathName;
	}

	/**
	 * 
	 * @return
	 */
	public int getPort() {
		return port;
	}

	/**
	 * 
	 * @return
	 */
	public String getProtocol(){
		if(protocol == null){
			protocol = "";
		}		
		return protocol;
	}

	/**
	 * 
	 * @return
	 */
	public String getContent(){
		if(content == null){
			content = "";
		}		
		return content;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMethod(){
		if(method == null){
			method = "";
		}		
		return method;
	}
	
	/**
	 * 
	 * @return
	 */
	public MessageType getType(){
		return type;
	}
	
	/**
	 * 
	 * @param type
	 */
	public void setType(MessageType type){
		this.type = type;
	}
	
	/**
	 * 
	 * @param body
	 */
	public void setBody(String body){
		this.body = body;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBody(){
		if(body == null){
			body = "";
		}
		return this.body;
	}
	
	/**
	 * Returns the complete message. url + url parameters
	 * @return
	 */
	public String getCompleteMessage(){
		StringBuffer sb = new StringBuffer();
		sb.append(protocol);
		sb.append("://");
		sb.append(host);
		sb.append(":");
		sb.append(port);
		sb.append(pathName);
		sb.append("?");
		sb.append(parameters);
		return sb.toString();
	}

	/**
	 * Returns the complete path. Url without url parameters
	 * @return
	 */
	public String getCompletePath(){
		StringBuffer sb = new StringBuffer();
		sb.append(protocol);
		sb.append("://");
		sb.append(host);
		sb.append(":");
		sb.append(port);
		sb.append(pathName);
		return sb.toString();
	}	
	
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Message => [");
		sb.append("protocol: ");
		sb.append(protocol);		
		sb.append(", port: ");
		sb.append(port);
		sb.append(", host: ");
		sb.append(host);
		sb.append(", pathname: ");
		sb.append(pathName);
		sb.append(", parameters: ");
		sb.append(parameters);
		sb.append(", content: ");
		sb.append(content);		
		sb.append("]");
		return sb.toString();
	}
	
}
