package com.theCyberian.RestAPi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.theCyberian.RestAPi.dbLayer.Customer;
import com.theCyberian.RestAPi.services.CustomerService;

@Path("/customers")
public class CustomerResource {

	@GET
	@Path("/getCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomers() {
		CustomerService customerService = new CustomerService();
		return (List<Customer>) customerService.getAllCustomers();
	}
	
	@GET
	@Path("/getCustomer/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerId(@PathParam("custId") String custId) {
		CustomerService customerService = new CustomerService();
		System.out.println(custId);
		return customerService.getCustomerWithId(custId);
	}
	
	@POST
	@Path("/addCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer addItems(Customer customer) {
		CustomerService customerService = new CustomerService();
		customerService.addCustomer(customer);
		return customer;
	}

}
