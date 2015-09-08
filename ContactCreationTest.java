package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase {
	
		
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(GroupContact contact) throws Exception {    
    
	    SortedListOf<GroupContact> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().createContact(contact);
		
		SortedListOf<GroupContact> newList = app.getContactHelper().getContacts();
        
        //assertEquals(newList.size(), oldList.size()+1);
        
		assertThat(newList, equalTo(oldList.withAdded(contact)));

  }
}
