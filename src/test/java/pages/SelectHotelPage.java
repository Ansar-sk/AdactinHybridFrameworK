package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectHotelPage extends basepage {
	@FindBy(xpath = "//td[input[@value='Hotel Creek']]/preceding-sibling::td/input[@type='radio']")
	WebElement radiobutton;
	
	@FindBy(xpath = "//tr/td/input[@name='hotel_name_0']")
	WebElement hotelname;
	
	@FindBy(xpath = "//input[@name='price_night_0']")
	WebElement pricepernight;
	
	@FindBy(xpath = "//input[@name='total_price_0']")
	WebElement totalprice;
	
	@FindBy(xpath = "//input[@id='room_type_0']")
	WebElement roomtype;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continuebutton;

	@FindBy(xpath = "//input[@id='cancel']")
	WebElement cancel;
	
	public void selectradio() {
		radiobutton.click();
	}
	public void selectcontinue() {
		continuebutton.click();
	}
	public void validateprice(String expprice) {
		validateattributes(pricepernight, expprice);
	}
	public void validatetotalprice(String expprice) {
		validateattributes(totalprice, expprice);
	}
	
	public void validateroomtype(String exptype) {
		validateattributes(roomtype, exptype);
	}
	public void cancel() {
		cancel.click();
	}
}
