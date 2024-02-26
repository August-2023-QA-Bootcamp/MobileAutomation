package unit;

import org.junit.jupiter.api.Test;

import base.BaseClass;

public class NativeAppTest extends BaseClass{

	@Test
	public void demo_test() {
		nativeHomePage.validateTitle("Products");
		nativeHomePage.validateItemName("Sauce Labs Bolt T-Shirt");
		nativeHomePage.validateItemPrice("$15.99");
		nativeHomePage.clickItem();
		itemPage.validateItemTitle("Sauce Labs Bolt T-Shirt");
	}
}
