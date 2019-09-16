package stepDefinition;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.GetterSetters;
import utilities.HttpMethodsForRestService;
import utilities.JsonOperations;

public class StepDefinitions {

	@Given("^User is provided with an end point for customers search$")
	public void user_is_provided_with_an_end_point_for_customers_search() throws Throwable {
		GetterSetters.setEndPoint("getCustomer");
		String url = JsonOperations.endPointsReader(GetterSetters.getEndPoint());

		System.out.println("[INFO] End point set to : " + GetterSetters.getEndPoint());
		System.out.println("[INFO] URL set to : " + url);

		GetterSetters.setUrl(url);
	}

	@Given("^User is provided with an end point for customer search$")
	public void user_is_provided_with_an_end_point_for_customer_search() throws Throwable {
		GetterSetters.setEndPoint("getCustomerWithId");

		System.out.println("[INFO] End point set to : " + GetterSetters.getEndPoint());

	}

	@When("^User hits the end point with GET request$")
	public void user_hits_the_end_point_with_GET_request() throws Throwable {
		System.out.println("[INFO] Hitting the end point with GET request...");
		HttpMethodsForRestService.getURL(GetterSetters.getUrl());
//		System.out.println("[INFO] Hitting the end point with GET request...");
	}

	@Then("^the API should respond with all the customers data$")
	public void the_API_should_respond_with_all_the_customers_data() throws Throwable {
		System.out.println("[INFO] Analyzing the response now...");
		JSONParser parser = new JSONParser();
		try {
			JSONArray json = (JSONArray) parser.parse(GetterSetters.getResponseJson());
			System.out.println(json);
		} catch (Exception e) {
			JSONObject json = (JSONObject) parser.parse(GetterSetters.getResponseJson());
			System.out.println(json);
		}
	}

	@When("^User hits the end point with GET request with (\\d+)$")
	public void user_hits_the_end_point_with_GET_request_with(int custId) throws Throwable {
		String url = JsonOperations.endPointsReader(GetterSetters.getEndPoint());
		System.out.println("[INFO] URL set to : " + String.format(url, custId));
		GetterSetters.setUrl(String.format(url, custId));

		System.out.println("[INFO] Hitting the end point with GET request...");
		HttpMethodsForRestService.getURL(GetterSetters.getUrl());
	}

	@Given("^User is provided with an end point for items search$")
	public void user_is_provided_with_an_end_point_for_items_search() throws Throwable {
		GetterSetters.setEndPoint("getItems");
		String url = JsonOperations.endPointsReader(GetterSetters.getEndPoint());

		System.out.println("[INFO] End point set to : " + GetterSetters.getEndPoint());
		System.out.println("[INFO] URL set to : " + url);

		GetterSetters.setUrl(url);
	}

	@Given("^User is provided with an end point for item search$")
	public void user_is_provided_with_an_end_point_for_item_search() throws Throwable {
		GetterSetters.setEndPoint("getItemWithId");

		System.out.println("[INFO] End point set to : " + GetterSetters.getEndPoint());
	}

	@Then("^the API should respond with all the items data$")
	public void the_API_should_respond_with_all_the_items_data() throws Throwable {
		System.out.println("[INFO] Analyzing the response now...");
		JSONParser parser = new JSONParser();
		try{
		JSONArray json = (JSONArray) parser.parse(GetterSetters.getResponseJson());
		System.out.println(json);
		}
		catch(Exception e) {
			JSONObject json = (JSONObject) parser.parse(GetterSetters.getResponseJson());
			System.out.println(json);	
		}
	}

}
