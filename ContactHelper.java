package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupContact;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<GroupContact> cachedContacts;
	
	public SortedListOf<GroupContact> getContacts () {
	if (cachedContacts == null) {
		rebuildCache ();
		
	}
	
	return cachedContacts; 
			   
	}
	 
	 private void rebuildCache() {
		  
		 SortedListOf<GroupContact> cachedContacts = new SortedListOf<GroupContact>();
		 manager. navigateTo(). mainPage();
			
		   List<WebElement> checkboxes = driver.findElements(By.xpath(".//td[5]"));
		   for (WebElement checkbox : checkboxes) {
			
				String name = checkbox. getText();  
				String home = name;
			
			//List<WebElement> rows = getContactRows();
			//for (WebElement row : rows) {
			//ContactObject contact = new ContactObject();
				// .setFirstName = row.findElement(By.xpath(".//td[2]")).getText();
				// .setLastName = row.findElement(By.xpath(".//td[3]")).getText();
			    // list.add(contact);
	            
				cachedContacts.add(new GroupContact().withHome(home));	
	   }  
	
	}

	public ContactHelper createContact(GroupContact contact) {
		manager. navigateTo(). mainPage();
		initContactCreation();
	    fillContactForm(contact, CREATION);
		submitContactCreation();
		returnToHomePage();
		rebuildCache ();
		return this;

	 }	
		public ContactHelper modifyContact(int index, GroupContact contact) {
			
			initContactModification(index);
			fillContactForm(contact, MODIFICATION );
			submitContactModification();
			returnToHomePage();
			rebuildCache ();
			return this;
		  
		
	}
	 public ContactHelper deleteContact(int index) {
			selectContactByIndex (index);
			submitContactDeletion();
			returnToHomePage();
			rebuildCache ();
			return this;

	}
	 
	 ///------------------------------------------------------------------
	
	public ContactHelper initContactCreation() {
			
		   click(By.linkText("add new"));
			return this;
	}
	
	public ContactHelper fillContactForm(GroupContact contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHome());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWork());
		type(By.name("email"), contact.getEmail1());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getDay());
		selectByText(By.name("bmonth"), contact.getMonth());
		
		type(By.name("byear"), contact.getYear());
		if (formType == CREATION ){
		//selectByText(By.name("new_group"), "group name 1");
		 } else {
		 if (driver.findElements (By.name ("new_group")).size () !=0) {
		  throw new Error ("Group selector exists in contact modification form");
		}
	}
		
		
		type(By.name("address2"), contact.getSecondaryaddress());
		type(By.name("phone2"), contact.getSecondaryhome());
		
		return this;
		   
	}
	
	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	
	}
	
	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
		  
	}
	

    private ContactHelper selectContactByIndex(int index) {
	    click(By.xpath("//tr["+ (index+1) +" + 1]/td[7]/a/img"));
	    return this;
	
   }

   public ContactHelper initContactModification(int index) {
	    selectContactByIndex (index);
	    return this;
   }
   
	
	public ContactHelper submitContactModification() {
		click(By.xpath("//form[1]/input[11]"));
		cachedContacts = null;
		return this;
						
		
   }

	public void submitContactDeletion() {
		click(By.xpath("//form[2]/input[2]"));
		cachedContacts = null;
	}
	 
}


