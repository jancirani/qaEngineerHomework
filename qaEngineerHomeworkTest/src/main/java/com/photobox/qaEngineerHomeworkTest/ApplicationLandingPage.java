package com.photobox.qaEngineerHomeworkTest;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationLandingPage extends BaseClass {

	Select dropDownValue; 
	public String selectTitle(String title) throws IOException {
		dropDownValue=new Select(getObject(null, ObjectRepository.getProperty("title"), null));
		dropDownValue.selectByVisibleText(title);
		return title;
				
	}

	public void enterSalry(String name, int sal) throws IOException {
		String salary=Integer.toString(sal);
		getObject(null, ObjectRepository.getProperty("name"), null).sendKeys(name);
		getObject(null, ObjectRepository.getProperty("salary"), null).sendKeys(salary);
		
		
	}

	public void calculateTax() throws IOException {
		getObject(ObjectRepository.getProperty("calculateTax"), null, null).click();
		
	}

	public void verifyExpedtedTaxAmount(int taxAmount) throws IOException {
		String expectedTaxAmount=Integer.toString(taxAmount);
		System.out.println(taxAmount);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getObject(null, ObjectRepository.getProperty("message"), null)));
		System.out.println(element.getText());
		System.out.println("************************************************");
		
		Assert.assertTrue(getObject(null, ObjectRepository.getProperty("message"), null).getText().contains(expectedTaxAmount));
			
	}

	public void verifyMessage(String message) throws IOException {
	Assert.assertEquals(getObject(null, ObjectRepository.getProperty("message"), null).getText(),message);
		
	}

}
