package com.openwide.easysoa.esperpoc;

import java.util.ArrayDeque;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.log4j.Logger;
import com.openwide.easysoa.esperpoc.esper.Message;

@SuppressWarnings("serial")
public class UrlTreeNode extends DefaultMutableTreeNode{

	/**
	 * Logger
	 */
	private static Logger logger = Logger.getLogger(UrlTreeNode.class.getName());
	
	/**
	 * 
	 */
	private String nodeName;
	
	/**
	 * An ArrayDeque to store the received messages corresponding to the node url
	 */
	private ArrayDeque<Message> msgs;
	
	/**
	 * 
	 */
	private int partialUrlCallCount;
	
	/**
	 * 
	 */
	private int completeUrlCallCount;

	/**
	 * @param urlPart
	 * @param counter
	 */
	public UrlTreeNode(String nodeName) {
		super();
		this.nodeName = nodeName;
		this.partialUrlCallCount = 0;
		this.completeUrlCallCount = 0;
		this.msgs = new ArrayDeque<Message>();
	}

	/**
	 * 
	 * @return
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * 
	 * @return
	 */
	public int getPartialUrlcallCount() {
		return partialUrlCallCount;
	}

	/**
	 * 
	 * @return
	 */
	public int getCompleteUrlcallCount() {
		return completeUrlCallCount;
	}	
	
	/**
	 * Increase the counter by 1
	 */
	public void increasePartialUrlCounter() {
		logger.debug("[increasePartialUrlCounter()] Increase partialUrlCallCount !!");
		this.partialUrlCallCount++;
	}
	
	/**
	 * Increase the counter by 1
	 */
	public void increaseCompleteUrlCounter() {
		logger.debug("[increasePartialUrlCounter()] Increase completeUrlCallCount !!");
		this.completeUrlCallCount++;
	}	
	/*
	public void getTotalChildNumber(){
		this.
	}
	*/
	
	/**
	 * Add a message in the message list 
	 */
	public void addMessage(Message msg){
		this.msgs.add(msg);
	}
	
	@Override
	public String toString(){
		StringBuffer st = new StringBuffer();
		st.append("[");
		st.append("node name : ");
		st.append(nodeName);
		st.append(", node partial url call count : ");
		st.append(partialUrlCallCount);
		st.append(", node complete url call count : ");
		st.append(completeUrlCallCount);		
		st.append("]");
		return st.toString();
	}

}