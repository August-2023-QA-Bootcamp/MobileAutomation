package common;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import loggers.Loggers;

public class CommonActions {

	public static void input(WebElement element, String inputValue) {
		try {
			element.sendKeys(inputValue);
			Loggers.log(element + "---> Input value: " + inputValue);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
			fail();
		}
	}

	public static void click(WebElement element) throws NoSuchElementException{
		try {
			element.click();
			Loggers.log(element + "---> Clicked ");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
			//fail();
		}
	}

	public static void verifyText(WebElement element, String expected) {
		String actual = element.getText();
		Loggers.log(element + " ---> Actula text : " + actual + ". Expected text : " + expected);
		assertEquals(actual, expected);
	}

	public static void verifyText(Object obj1, Object obj2) {
		Loggers.log(obj1 + " ---> Comparing with : ---> " + obj2);
		assertEquals(obj1, obj2);
	}

	public static void clear(WebElement element) {
		try {
			element.clear();
			Loggers.log(element + " ---> cleared");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
			fail();
		}
	}

	public static void verifyTitle(WebDriver driver, String expectedTitle) {
		try {
			Loggers.log("Actual Title is : " + driver.getTitle() + "---> And Expected Title is :" + expectedTitle);
			assertEquals(driver.getTitle(), expectedTitle);
		} catch (NullPointerException e) {
			e.printStackTrace();
			Loggers.log("driver is not initiated properly");
			fail();
		}
	}

	public static void hoverOverOnly(WebDriver driver, WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			Loggers.log("Hovering on ---> " + element);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
			fail();
		}
	}

	public static void hoverOverTo(WebDriver driver, WebElement src_element, WebElement target_element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(src_element).click(target_element).build().perform();
			Loggers.log("Hovering on ---> " + src_element);
			Loggers.log("Clicking on ---> " + target_element);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(src_element + " || " + target_element + " ---> Not Found \n" + e.getMessage());
			fail();
		}
	}

	public static void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
