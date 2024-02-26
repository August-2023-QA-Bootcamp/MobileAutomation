package page.webview;

import static common.CommonActions.click;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IOSHomePage implements IHomePage{

	public IOSHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "")
	WebElement amazonLogo;
	
	@FindBy(xpath = "")
	WebElement hamburgerMenu;
	
	@FindBy(xpath = "")
	WebElement threndingBtn;

	@Override
	public void clickLogo() {
		try {
			click(amazonLogo);
		} catch (NoSuchElementException e) {

		}
	}

	@Override
	public void clickHamburgerMenu() {
		try {
			click(hamburgerMenu);
		} catch (NoSuchElementException e) {
			Assertions.fail();
		}
	}

	@Override
	public void clickThrending() {
		try {
			click(threndingBtn);
		} catch (NoSuchElementException e) {
			Assertions.fail();
		}
	}
}
