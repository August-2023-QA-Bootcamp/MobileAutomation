package page.nativeapp.nyt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.CommonActions.*;

public class NYTHomePage {

	public NYTHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.google.android.gms:id/cancel")
	WebElement cancel;
	
	public void cancel() {
		click(cancel);
	}
}
