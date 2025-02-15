package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookHotel extends basepage { 
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastname;
	
	@FindBy(xpath = "//textarea[@id='address']")
	WebElement billingaddress;
	
	@FindBy(xpath = "//input[@id='cc_num']")
	WebElement cardnumber;
	
	@FindBy(xpath = "//select[@id='cc_type']")
	WebElement cardtype;
	
	@FindBy(xpath = "//select[@id='cc_exp_year']")
	WebElement expiryyear;
	
	@FindBy(xpath = "//select[@id='cc_exp_month']")
	WebElement expirymonth;
	
	@FindBy(xpath = "//input[@id='cc_cvv']")
	WebElement cvv;
	
	@FindBy(xpath = "//input[@id='book_now']")
	WebElement booknow;
	
	@FindBy(xpath = "//input[@id='cancel']")
	WebElement cancel;
	
	@FindBy(xpath = "//input[@name='order_no']")
	WebElement orderid;
	
	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	WebElement bookediternary;
	
	public void enterfirstname(String text) {
		type(firstname, text);
	}
	public void enterlastname(String text) {
		type(lastname, text);
	}
	public void address(String text) {
		type(billingaddress, text);
	}
	public void entercardnumber(String text) {
		type(cardnumber, text);
	}
	public void selectcardtype(String text) {
		selectdropdown(cardtype, text);
	}
	public void selectexpiryyear(String text) {
		selectdropdown(expiryyear, text);
	}
	public void selectexpirymonth(String text) {
		selectdropdown(expirymonth, text);
	}
	public void entercvv(String text) {
		type(cvv, text);
	}
	public void book() {
		booknow.click();
	}
	public void getiternary() {
		bookediternary.click();
	}
	public String getorderid() {
return getattribute(orderid);
	}
}
