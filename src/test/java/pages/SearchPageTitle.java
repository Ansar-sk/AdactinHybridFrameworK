package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageTitle extends basepage {

	@FindBy(xpath = "//select[@name='location']")
	WebElement Location;

	@FindBy(xpath = "//select[@name='hotels']")
	WebElement Hotels;

	@FindBy(xpath = "//select[@name='room_type']")
	WebElement Roomtype;

	@FindBy(xpath = "//select[@name='room_nos']")
	WebElement NumOfRooms;

	@FindBy(xpath = "//input[@name='datepick_in']")
	WebElement Checkindate;

	@FindBy(xpath = "//input[@name='datepick_out']")
	WebElement Checkoutdate;

	@FindBy(xpath = "//select[@name='adult_room']")
	WebElement Adultsperroom;

	@FindBy(xpath = "//select[@name='child_room']")
	WebElement Childrenperroom;

	@FindBy(xpath = "//input[@name='Submit']")
	WebElement searchButton;

	public void locationfield(String text) {
		selectdropdown(Location, text);
	}

	public void hotelField(String text) {
		selectdropdown(Hotels, text);
	}

	public void roomTypeField(String text) {
		selectdropdown(Roomtype, text);
	}

	public void numOfRoomsField(String text) {
		selectdropdown(NumOfRooms, text);
	}

	public void checkIn(String text) {
		type(Checkindate, text);
	}

	public void checkOut(String text) {
		type(Checkindate, text);
	}

	public void adultsperRoom(String text) {
		selectdropdown(Adultsperroom, text);
	}

	public void childrenPerRoom(String text) {
		selectdropdown(Childrenperroom, text);
	}

	public void searchbutton() {
		click(searchButton);
	}
	public void verifypagetitle(String exptitle) {
		verifytitle(exptitle);
	}
	

}
