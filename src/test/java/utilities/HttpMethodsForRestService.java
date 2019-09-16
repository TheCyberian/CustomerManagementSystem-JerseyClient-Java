package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpMethodsForRestService {

	public static void main(String[] args) {
//		String jsonData = "{\"itemName\": \"ItemTestInsert1\"}";
//		getURL("http://127.0.0.1:5000/getCustomer");
//		getURL("http://127.0.0.1:5000/getItems");
//		postURLAndData("http://127.0.0.1:5000/addItem", jsonData);
	}

	public static void getURL(String Url) {

		try {

			URL url = new URL(Url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			StringBuffer response = new StringBuffer();
			String output = br.readLine();
			response.append(output);
			System.out.println("[INFO] Response from Server...");
			while ((output = br.readLine()) != null) {
//				output = br.readLine();
//				System.out.println(output);
				response.append(output);
			}
			
//			System.out.println(response);
			GetterSetters.setResponseJson(response.toString());
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public static void postURLAndData(String Url, String jsonData) {
		try {

			URL url = new URL(Url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = jsonData;

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
