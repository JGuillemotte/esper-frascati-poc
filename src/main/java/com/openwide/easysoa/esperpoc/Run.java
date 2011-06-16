package com.openwide.easysoa.esperpoc;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import org.apache.log4j.Logger;
import com.openwide.easysoa.monitoring.Message;

public class Run {

	/**
	 * Logger
	 */
	private static Logger logger = Logger.getLogger(Run.class.getName());
	
	/**
	 * The messages collection
	 */
	private ArrayDeque<Message> messagesList;
	
	/**
	 * Start run date
	 */
	private Date startDate;
	
	/**
	 * Stop run date
	 */
	private Date stopDate;
	
	/**
	 * Run name
	 */
	private String name;
	
	// Contains a collection of messages & informations like startDate, stopDate...
	
	/**
	 * Initialize a new <code>Run</code> instance 
	 */
	public Run(String name) throws IllegalArgumentException {
		if(name == null){
			throw new IllegalArgumentException("name parameter must not be null");
		}
		this.name = name;
		messagesList = new ArrayDeque<Message>();
		startDate = null;
		stopDate = null;
	}
	
	/**
	 * Add a message
	 * @param message The message to add in the collection
	 */
	public void addMessage(Message message) throws IllegalArgumentException {
		if(message == null){
			throw new IllegalArgumentException("The parameter message must not be null !");
		}
		logger.debug("Adding message in message list : " + message);
		this.messagesList.add(message);
	}
	
	/**
	 * Returns the message list
	 * @return The message list in a <code>Deque</code>
	 */
	public Deque<Message> getMessageList(){
		return this.messagesList;
	}
	
	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}

	/**
	 * 
	 * @param stopDate
	 */
	public void setStopDate(Date stopDate){
		this.stopDate = stopDate;
	}

	/**
	 * Returns the run start date
	 * @return The run start <code>Date</code> or null if the start date has not been set before
	 */
	public Date getStartDate(){
		return this.startDate;
	}

	/**
	 * Get the run stop date
	 * @return The run stop <code>Date</code> or null if the stop date has not been set before.
	 */
	public Date getStopDate(){
		return this.stopDate;
	}

	/**
	 * Returns the run name
	 * @return A<code>String</code> for the run name
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) throws IllegalArgumentException {
		if(name == null){
			throw new IllegalArgumentException();
		}
		this.name = name;
	}
	
}
