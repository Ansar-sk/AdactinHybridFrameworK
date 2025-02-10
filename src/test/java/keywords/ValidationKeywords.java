package keywords;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class ValidationKeywords extends GenericKeywords {
	public void ValidateTitle(String exptitle) {
		Assert.assertEquals(getTitle(), exptitle);
		test.log(Status.PASS, "Title matched");
}
	public void ValidateText(String Locator, String text)
	{
		Assert.assertEquals(gettext(Locator), text);
	}
	public void Validateattributes(String locator, String tag, String exptagvalue) {
	Assert.assertEquals(getattribute(locator, tag), exptagvalue);
			}
	
	public Object ValidateTotalPrice(String locator1, String text1,String locator2, String text2,String locator3, String text3) {
		
		String rooms =getattribute(locator1, text1);
		String days =getattribute(locator2, text2);
		String pricepernight =getattribute(locator3, text3);
		
		int numofRooms = extractNumber(rooms);
		int noOfDays = extractNumber(days);
		int perNightPrice = extractNumber(pricepernight);
		
		int Totalprice = numofRooms*noOfDays*perNightPrice;
		double gst = Totalprice*0.10;
		double totalPriceWithGst = Totalprice+gst;
		int totalPriceWithGstInt = (int) totalPriceWithGst;
		return totalPriceWithGstInt;
		}
	
	public static int extractNumber(String input) {
        // Use regex to extract the first number
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
            }
		return 0;
}
	}
