package com.theCyberian.RestAPi.services;

import java.util.ArrayList;

import com.theCyberian.RestAPi.dbLayer.DatabaseAccessLayer;
import com.theCyberian.RestAPi.dbLayer.Items;

public class ItemsService {

	public ArrayList<Items> getAllItems() {
		DatabaseAccessLayer dbObject = new DatabaseAccessLayer();
		ArrayList<String[]> listOfItems = dbObject.getItemsDataFromDb();
		
		ArrayList<Items> itemsForService = new ArrayList<Items>();

		for (int i = 0; i < listOfItems.size(); i++) {
			Items i1 = new Items(listOfItems.get(i)[0], listOfItems.get(i)[1]);
			itemsForService.add(i1);
		}

		return itemsForService;
	}
	
	public Items getItemWithId(String itemId) {
		DatabaseAccessLayer dbObject = new DatabaseAccessLayer();
		ArrayList<String> itemsData = dbObject.getItemDataFromDb(itemId);
		
		Items i1 = new Items(itemsData.get(0),itemsData.get(1));
		
		return i1;
	}
	
	public void addItem(Items item) {
		DatabaseAccessLayer dbObject = new DatabaseAccessLayer();
		dbObject.addItemsToTable(item);
	}
}
