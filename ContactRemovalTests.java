package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact () {
		
		SortedListOf<GroupContact> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random ();
		int index = rnd.nextInt(oldList.size() - 1);
		
	    app.getContactHelper().deleteContact(index);
	 
	    
	    SortedListOf<GroupContact> newList = app.getContactHelper(). getContacts();
	    
	    assertThat(newList, equalTo(oldList.without(index)));
	   	    
	 }
}
