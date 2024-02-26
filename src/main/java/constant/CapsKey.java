package constant;

public enum CapsKey {

	PLATFORM("platform"),
	PLATFORM_VER("platform_version"),
	DEVICE_NAME("device_name"),
	APP_PATH("app"),
	BS_APP_ID("app_id"),
	APP_ACTIVITY("app_activity"),
	APP_PACKAGE("app_package");
	
	String value;
	
	private CapsKey(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
