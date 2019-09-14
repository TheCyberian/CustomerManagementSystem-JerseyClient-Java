package com.theCyberian.RestAPi.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.theCyberian.RestAPi.dbLayer.Customer;
import com.theCyberian.RestAPi.services.CustomerService;

@Path("/getCustomers")
public class CustomerResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Customer> getCustomers() {
		CustomerService customerService = new CustomerService();
		return (List<Customer>) customerService.getAllCustomers();
	}
	
	@GET
	@Path("/{custId}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomerId(@PathParam("custId") String custId) {
		CustomerService customerService = new CustomerService();
		System.out.println(custId);
		return customerService.getCustomerWithId(custId);
	}

}
