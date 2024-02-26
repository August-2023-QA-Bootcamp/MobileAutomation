package unit;

import org.junit.jupiter.api.Test;

import constant.CapsKey;
import constant.CommonKey;
import util.Configuration;
import util.Configuration.Type;

public class ConfigTest {

	@Test
	public void testKey() {
		System.err.println(CapsKey.APP_ACTIVITY.getValue());
		
		Configuration commonConfig = new Configuration(Type.COMMON);
		System.err.println(commonConfig.get(CommonKey.BROWSER));
		
		Configuration capsConfig = new Configuration(Type.DESIRE_CAPS);
		System.err.println(capsConfig.get(CapsKey.DEVICE_NAME));
	}
}
