package com.theCyberian.RestAPi.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.theCyberian.RestAPi.dbLayer.Items;
import com.theCyberian.RestAPi.services.ItemsService;

@Path("/getItems")
public class ItemsResource {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Items> getItems() {
		ItemsService itemService = new ItemsService();
		return (List<Items>) itemService.getAllItems();
	}
	
	@GET
	@Path("/{itemId}")
	@Produces(MediaType.APPLICATION_XML)
	public Items getItemsId(@PathParam("itemId") String itemId) {
		
		return null;
	}
}
