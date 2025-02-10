package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class loginpage extends basepage {

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernametextbox;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordtextbox;
	
	@FindBy(xpath = "//input[@name='login']")
	WebElement loginbutton;
	
	public  void usernametextfield(String text) {
		//usernametextbox.sendKeys(text);
		type(usernametextbox, text);
	}
	
	public void passwordtextfield(String text) {
		type(passwordtextbox, text);
	}
	
	public void loginbuttonfield() {
		click(loginbutton);
	}
	public void verifypagetitle(String exptitle) {
		verifytitle(exptitle);
	}

}
