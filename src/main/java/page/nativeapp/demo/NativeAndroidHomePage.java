package page.nativeapp.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.CommonActions.*;

public class NativeAndroidHomePage implements INativeHomePgae{

	public NativeAndroidHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
	WebElement title;
	
	@FindBy(xpath = "(//android.widget.TextView[@content-desc=\"store item text\"])[3]")
	WebElement boltT_shirt;
	
	@FindBy(xpath = "(//android.widget.TextView[@content-desc=\"store item price\"])[3]")
	WebElement boltT_shirt_price;
	
	@Override
	public void validateTitle(String expectedTitle) {
		verifyText(title, expectedTitle);
	}

	@Override
	public void clickItem() {
		click(boltT_shirt);
	}

	@Override
	public void validateItemName(String expectedName) {
		verifyText(boltT_shirt, expectedName);
		
	}

	@Override
	public void validateItemPrice(String expectedPrice) {
		verifyText(boltT_shirt_price, expectedPrice);
		
	}

}
