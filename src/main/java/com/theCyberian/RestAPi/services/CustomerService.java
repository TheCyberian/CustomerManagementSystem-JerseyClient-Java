package com.theCyberian.RestAPi.services;

import java.util.ArrayList;

import com.theCyberian.RestAPi.dbLayer.Customer;
import com.theCyberian.RestAPi.dbLayer.DatabaseAccessLayer;

public class CustomerService {

	public ArrayList<Customer> getAllCustomers() {
		DatabaseAccessLayer dbObject = new DatabaseAccessLayer();
		ArrayList<String[]> listOfCustomers = dbObject.getCustomerDataFromDb();
		
		ArrayList<Customer> customersForService = new ArrayList<Customer>();

		for (int i = 0; i < listOfCustomers.size(); i++) {
			Customer c1 = new Customer(listOfCustomers.get(i)[0], listOfCustomers.get(i)[1], listOfCustomers.get(i)[2],
					listOfCustomers.get(i)[3], listOfCustomers.get(i)[4], listOfCustomers.get(i)[5],
					listOfCustomers.get(i)[6], listOfCustomers.get(i)[7], listOfCustomers.get(i)[8],
					listOfCustomers.get(i)[9]);
			customersForService.add(c1);
		}
		System.out.println(customersForService.get(0));
		return customersForService;
	}

	
	public Customer getCustomerWithId(String CustId) {
		DatabaseAccessLayer dbObject = new DatabaseAccessLayer();
		ArrayList<String> customerData = dbObject.getCustomerDataFromDb(CustId);
		
		System.out.println(CustId);
		
		Customer c1 = new Customer(customerData.get(0),customerData.get(1), customerData.get(2),
				customerData.get(3), customerData.get(4), customerData.get(5), customerData.get(6),
				customerData.get(7), customerData.get(8), customerData.get(9));
		
		return c1;
	}
//	public static void main(String ar[]) {
//		CustomerService customerService = new CustomerService();
//		System.out.println(customerService.getAllCustomers().size());
//	}
}
