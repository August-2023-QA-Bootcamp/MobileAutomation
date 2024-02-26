package unit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class WebViewTest extends BaseClass{
	
	@Test
	public void test() {
		
		try {
			WebElement amazonLogo = getDriver().findElement(By.id("nav-bb-logo"));
			amazonLogo.click();
		} catch (NoSuchElementException e) {
			
		}
		
		WebElement hamburgerMenu = getDriver().findElement(By.xpath("(//android.widget.Button)[1]"));
		hamburgerMenu.click();
		
		WebElement threndingBtn = getDriver().findElement(By.xpath("(//android.view.View)[27]"));
		System.out.println(threndingBtn.getText());
		threndingBtn.click();
		
	}
}
