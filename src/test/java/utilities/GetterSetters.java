package utilities;

public class GetterSetters {

	static String endPoint;
	static String url;
	static String responseJson;

	public static String getResponseJson() {
		return responseJson;
	}

	public static void setResponseJson(String responseJson) {
		GetterSetters.responseJson = responseJson;
	}

	public static String getEndPoint() {
		return endPoint;
	}

	public static void setEndPoint(String endPoint) {
		GetterSetters.endPoint = endPoint;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		GetterSetters.url = url;
	}
}
