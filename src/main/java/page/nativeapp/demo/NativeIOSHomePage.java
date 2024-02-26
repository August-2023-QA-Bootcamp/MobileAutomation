package page.nativeapp.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NativeIOSHomePage implements INativeHomePgae{

	public NativeIOSHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@Override
	public void clickItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateTitle(String expected) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateItemName(String expected) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateItemPrice(String expected) {
		// TODO Auto-generated method stub
		
	}

}
