package webview;

import org.junit.jupiter.api.Test;

import base.BaseClass;

public class WebViewAmazonTest extends BaseClass{

	@Test
	public void test() {
		homePage.clickLogo();
		homePage.clickHamburgerMenu();
		homePage.clickThrending();
	}
}
