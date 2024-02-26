package constant;

public enum CommonKey {

	BROWSER("browser"),
	COMMON_APP("browser_app"),
	BROWSER_PACKAGE("browser_package"),
	BROWSER_ACTIVITY("browser_activity"),
	WAIT("wait"),
	INSTALL("installation"),
	RESET("full_reset"),
	REMOTE("deploy_remote"),
	URL("url"),
	REMOTE_URL("remote_url"),
	LOCAL_URL("local_url"),
	EXECUTION("execution")
	;
	
	String value;
	
	private CommonKey(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
