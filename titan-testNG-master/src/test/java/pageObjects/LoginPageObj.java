package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BaseTest;

public class LoginPageObj extends BaseTest{
	
	//we will create a constructor and use the PageFactory class from Selenium and use the initElement() method
	//to initialize our variables in this class
	public LoginPageObj() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='TEST ENVIRONMENT']")
	private WebElement testEnvironmentText;
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountButton;
	@FindBy(xpath = "//ul//a[text()='Login']")
	private WebElement loginLink;
	@FindBy(id = "input-email")
	private WebElement emailAddressField;
	@FindBy(id = "input-password")
	private WebElement passwordField;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement myAccountPage;
	
	public String getTestEnvironmentText() {
		String textFromUI = testEnvironmentText.getText();
		return textFromUI;
	}
	public void clickOnMyAccountButton() {
		myAccountButton.click();
	}
	public void clickOnLoginLink() {
		loginLink.click();
	}
	public void enterEmail(String email) {
		emailAddressField.sendKeys(email);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public String getTextAfterLogin() {
		String myAccountText = myAccountPage.getText();
		return myAccountText;
	}
	
	
	
	
	

}
