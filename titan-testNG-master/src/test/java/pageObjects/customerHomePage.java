package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BaseTest;

public class customerHomePage extends BaseTest{
	
	public customerHomePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@formcontrolname='username']")
	private WebElement userName;
	@FindBy(id = "//*[@formcontrolname='password']")
	private WebElement password;
	@FindBy(id = "//*[@class='mat-button-wrapper' and contains(text(), 'Login')]/..")
	private WebElement loginBTN;
	
	
	
	

}
