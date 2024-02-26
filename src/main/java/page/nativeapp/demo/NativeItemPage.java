package page.nativeapp.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.CommonActions.*;

public class NativeItemPage {

	public NativeItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
	WebElement itemTitle;
	
	public void validateItemTitle(String expected) {
		verifyText(itemTitle, expected);
	}
}
