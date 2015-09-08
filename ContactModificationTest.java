package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTest extends TestBase {
	

	@Test(dataProvider = "randomValidContactGenerator") 
	public void modifySomeContact (GroupContact contact) {
		
		SortedListOf<GroupContact> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random ();
		int index = rnd.nextInt(oldList.size() - 1);
		
		app.getContactHelper().modifyContact(index, contact);
		
		SortedListOf<GroupContact> newList = app.getContactHelper(). getContacts();
        
	    
	   oldList.remove(index);
	   oldList.add(contact);
	  
	   assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	
	}

}
