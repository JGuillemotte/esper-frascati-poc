package com.openwide.easysoa.monitoring.apidetector;

import java.util.ArrayList;

/**
 * URL mock storage to test the detection of API/Services
 * 
 * @author jguillemotte
 *
 */
public class UrlMock {

	/**
	 *  
	 */
	private ArrayList<String> freebooksTestSet;
	/**
	 * 
	 */
	private ArrayList<String> iMediaTestSet;
	/**
	 * 
	 */
	private ArrayList<String> twitterTestSet;
	
	/**
	 * Variables used by the iMedia data set at init
	 */
	private String prevDvdId = "";
	private String prevBookId = "";
	
	/**
	 * Init the mocker
	 */
	public UrlMock(){
		// Old data test set
		freebooksTestSet = new ArrayList<String>();
		freebooksTestSet.add("http://www.freebooks.org/library/getBook/15214-2584-44554");
		freebooksTestSet.add("http://www.freebooks.org/library/getBook/15487-9985-87751");
		freebooksTestSet.add("http://www.freebooks.org/library/getBook/12997-5799-73346");
		freebooksTestSet.add("http://www.freebooks.org/library/getDvd/99547-8854-26635");
		freebooksTestSet.add("http://www.freebooks.org/library/getDvd/99547-8854-39584");
		freebooksTestSet.add("http://www.tests.org/maven/PerformTest/ZEDF84558");
		freebooksTestSet.add("http://www.tests.org/maven/PerformTest/ZZED7584");
		freebooksTestSet.add("http://www.tests.org/maven/PerformTest/854DDS");
		freebooksTestSet.add("http://www.tests.org/maven/PerformTest/DEEED584");
		freebooksTestSet.add("http://www.tests.org/maven/PerformTest/ZZS7584");
		
		// imedia (fictive) data test set
		iMediaTestSet = new ArrayList<String>();
		iMediaTestSet.add("http://www.imedia.com/shop/getBookList/page1");
		iMediaTestSet.add("http://www.imedia.com/shop/getBookList/page2");
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getBook/{bookId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getBook/{bookId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getBook/{bookId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/addBookToBasket/{prevBookId}"));
		iMediaTestSet.add("http://www.imedia.com/shop/getBookList/page3");
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getBook/{bookId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getBook/{bookId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getBook/{bookId}"));
		iMediaTestSet.add("http://www.imedia.com/shop/getBookList/page4");
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getBook/{bookId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getBook/{bookId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/addBookToBasket/{prevBookId}"));
		iMediaTestSet.add("http://www.imedia.com/shop/getDvdList/page1");
		iMediaTestSet.add("http://www.imedia.com/shop/getDvdList/page2");
		iMediaTestSet.add("http://www.imedia.com/shop/getDvdList/page2");
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getDvd/{dvdId}"));
		iMediaTestSet.add("http://www.imedia.com/shop/getDvdList/page4");
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getDvd/{dvdId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getDvd/{dvdId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getDvd/{dvdId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/getDvd/{dvdId}"));
		iMediaTestSet.add(generateRandomIDs("http://www.imedia.com/shop/addDvdToBasket/{prevDvdId}"));
	
		// Twitter data test set
		twitterTestSet = new ArrayList<String>();
		twitterTestSet.add("http://api.twitter.com/1/users/show/FR3Aquitaine.xml");
		twitterTestSet.add("http://api.twitter.com/1/users/show/EasySoaTest.xml");
		twitterTestSet.add("http://api.twitter.com/1/users/show/FR3Aquitaine.json");
		twitterTestSet.add("http://api.twitter.com/1/users/show/FR3Bourgone.xml");
		twitterTestSet.add("http://api.twitter.com/1/users/show/FR3Bourgogne.json");
		twitterTestSet.add("http://api.twitter.com/1/users/show/truckblogfr.xml");
		twitterTestSet.add("http://api.twitter.com/1/users/show/OliverTweett.xml");
		twitterTestSet.add("http://api.twitter.com/1/users/show/Developpez.xml");
		twitterTestSet.add("http://api.twitter.com/1/users/show/europe_camions.xml");
		twitterTestSet.add("http://api.twitter.com/1/users/show/OliverTweett.json");
		twitterTestSet.add("http://api.twitter.com/1/users/show/FR3Aquitaine.xml");
		twitterTestSet.add("http://api.twitter.com/1/statuses/friends/oliverTweett.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/friends/FR3Aquitaine.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/friends/europe_camions.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/friends/Developpez.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/friends/FR3Bourgone.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/friends/EasySoaTest.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/followers/europe_camions.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/followers/Developpez.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/followers/FR3Aquitaine.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/followers/oliverTweett.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/followers/Developpez.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/followers/FR3Bourgone.xml?cursor=-1");
		twitterTestSet.add("http://api.twitter.com/1/statuses/followers/EasySoaTest.xml?cursor=-1");
	}

	/**
	 * To get the freebooks URL data set
	 * @return The freebooks URL data set
	 */
	public ArrayList<String> getFreebooksUrlData(){
		return freebooksTestSet;
	}

	/**
	 * To get the iMedia URL data set
	 * @return The iMedia URL data set
	 */
	public ArrayList<String> getIMediaUrlData(){
		return iMediaTestSet;
	}
	
	/**
	 * To get the Twitter URL data set
	 * @return The Twitter URL data set
	 */
	public ArrayList<String> getTwitterUrlData(){
		return twitterTestSet;
	}
	
	/**
	 * Replace template with random numbers
	 * @param template The String with the template to replace
	 * @return A String with a replaced value
	 */
	private String generateRandomIDs(String template){
		if(template.contains("{bookId}")){
			prevBookId = "" + Math.round(Math.random() * 1000);
			return template.replace("{bookId}", prevBookId);
		} else if(template.contains("{dvdId}")){
			prevDvdId = "" + Math.round(Math.random() * 1000);
			return template.replace("{dvdId}", prevDvdId);
		} else if(template.contains("{prevBookId}")){
			return template.replace("{prevBookId}", prevBookId);
		} else {
			return template.replace("{prevDvdId}", prevDvdId);
		}
	}
	
}
