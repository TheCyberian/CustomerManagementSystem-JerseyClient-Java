package com.theCyberian.RestAPi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.theCyberian.RestAPi.dbLayer.Items;
import com.theCyberian.RestAPi.services.ItemsService;

@Path("/items")
public class ItemsResource {
	@GET
	@Path("/getItems")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Items> getItems() {
		ItemsService itemService = new ItemsService();
		return (List<Items>) itemService.getAllItems();
	}

	@GET
	@Path("/getItems/{itemId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Items getItemsId(@PathParam("itemId") String itemId) {
		ItemsService itemService = new ItemsService();
		return itemService.getItemWithId(itemId);
	}

	@POST
	@Path("/addItems")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Items addItems(Items item) {
		ItemsService itemService = new ItemsService();
		itemService.addItem(item);
		return item;
	}
}
