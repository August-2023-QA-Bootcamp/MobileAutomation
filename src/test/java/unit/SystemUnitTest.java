package unit;

import java.io.File;

import org.junit.jupiter.api.Test;

public class SystemUnitTest {

	@Test
	public void test() {
		//System.err.println(System.getProperty("os.name"));
		File file = new File("src/test/resources/Demo.apk");
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		
		String aString = "true";
		System.err.println(!Boolean.parseBoolean(aString));
	}
}
