package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;
	private String name; 

	
	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager ();

	}
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop(); 
	   
	 }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random ();		
		for ( int i = 0; i < 5; i++ ) {
		GroupData group = new GroupData()
		 .withName (generateRandomString ())
		 .withHeader(generateRandomString ())
		 .withFooter(generateRandomString ());
		 
       	list.add(new Object[]{group});
		
		
	} 
		
		return list.iterator() ;
	
	}

	public String generateRandomString () {
		Random rnd = new Random ();
		if (rnd.nextInt(10) == 0) {
			return "";
		} else 
		    return "test" + rnd.nextInt();
			
		}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
    List<Object[]> list = new ArrayList<Object[]>();
    Random rnd = new Random();
    for (int i = 0; i< 5; i ++) {
    	GroupContact contact = new GroupContact()
    			
    	.withFirstname (genetateRandomString())
    	.withLastname(genetateRandomString())
    	.withAddress(genetateRandomString())
    	.withHome(genetateRandomString())
    	.withMobile(genetateRandomString())
    	.withWork(genetateRandomString())
    	.withEmail1(genetateRandomString())
    	.withEmail2(genetateRandomString())
    	.withDay("-")
    	.withMonth("-")
    	.withYear(genetateRandomString())
    	.withSecondaryaddress(genetateRandomString())
    	.withSecondaryhome(genetateRandomString());
        		   
		list.add(new Object [] {contact});
		
    }
    return list.iterator();
    }
	
	public String genetateRandomString() {
		Random rnd = new Random();
		
		if (rnd.nextInt(8) == 0) {
			return "";
		} else 
		if (rnd.nextInt(8) != 0 )  {
			return "-"; }
			return "test" + rnd.nextInt();
			
			
	}
}
	

