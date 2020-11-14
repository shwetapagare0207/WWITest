package com.wwi.qa.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wwi.qa.base.TestBase;

public class LocationPage extends TestBase {
	
	@FindBy(xpath = "//h1[contains(text(),'WW Studio Flatiron')]")
	WebElement locName;
	
	@FindBy(xpath = "//div[contains(text(), 'Business hours')]")
	WebElement businessHourBtn;
	
	List<WebElement> list1 = driver.findElements(By.className("day-CZkDC"));
	ListIterator<WebElement> listOfDayTime = list1.listIterator();
	
	List<WebElement> list2 = driver.findElements(By.className("dayName-CTNC6"));
	ListIterator<WebElement> listOfDays = list2.listIterator();
	
	List<WebElement> list3 = driver.findElements(By.className("day-NhBOb"));
	ListIterator<WebElement> listOfAppointments = list3.listIterator();
	
	List<WebElement> list4 = driver.findElements(By.className("dayName-1UpF5"));
	ListIterator<WebElement> listOfApptDays = list4.listIterator();

	public LocationPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyLocationTitleEqualsSearchResult() {
		return locName.getText();
	}

	public String todaysHoursOfOperations() {
		WebElement elementOfDayTime = null;
		WebElement elementOfDays = null;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE"); 
		String today = sdf.format(now);
		businessHourBtn.click();
		
		while(listOfDayTime.hasNext()) {
			 elementOfDayTime = listOfDayTime.next();
			 elementOfDays = listOfDays.next();
			if(today.equals(elementOfDays.getText())) 
			{
				break;
			}
		}
		
		return elementOfDayTime.getText();
	}
	
	public Map<String, Integer> todaysAppointments() {
		WebElement elementOfAppointments = null;
		WebElement elementOfApptDays = null;
		Scanner scanner = new Scanner(System. in);
		System.out.println("Enter any day of a week");
	    String day = scanner.nextLine();
	     
		while(listOfAppointments.hasNext()) {
			while(listOfApptDays.hasNext()) {
				elementOfAppointments = listOfAppointments.next();
				elementOfApptDays = listOfApptDays.next();
				if(elementOfApptDays.getText().equals(day)) {
					break;
				}
			
			}
			break;
		}
		
		String appointment = new String();
		appointment = elementOfAppointments.getText();
		String[] people = appointment.split("\\r?\\n");
		List<String> person = new ArrayList<>();
		
		for(int i=2; i<people.length; i+=2) {
			person.add(people[i]);
		}
				
			
		//return person;
		Map<String, Integer> map1 = new HashMap<>();
		for(String name : person) {
			Integer count = map1.get(name);
			if(count == null) {
				count = 0;
			}
			map1.put(name, count+1);
		}
		
		for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
		
		return map1;
		
	}
	 
}
