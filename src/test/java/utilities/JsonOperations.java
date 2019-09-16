package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonOperations {

	public static String endPointsReader(String endPointName) {

		JSONParser jsonParser = new JSONParser();
		String url = "";
//		try (FileReader reader = new FileReader("src/test/resources/testData/endPoints.json")) {
		try (FileReader reader = new FileReader("src/main/resources/endPoints.json")) {
			Object obj = jsonParser.parse(reader);
			JSONObject jsonObject = (JSONObject) obj;

			url = (String) jsonObject.get(endPointName);
//			System.out.println(url);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return url;
	}

//	public static void main(String[] args) {
//		endPointsReader("getCustomer");
//	}

}
