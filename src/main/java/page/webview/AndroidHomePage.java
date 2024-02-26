package page.webview;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.CommonActions.*;

public class AndroidHomePage implements IHomePage {

	public AndroidHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-bb-logo")
	WebElement amazonLogo;

	@FindBy(xpath = "(//android.widget.Button)[1]")
	WebElement hamburgerMenu;

	@FindBy(xpath = "(//android.view.View)[27]")
	WebElement threndingBtn;

	@Override
	public void clickLogo() {
		try {
			Thread.sleep(5000);
			//click(amazonLogo);
		} catch (NoSuchElementException | InterruptedException e) {

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
