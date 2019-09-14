package com.theCyberian.RestAPi.dbLayer;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Items {

	private String itemNumber;
	private String itemName;
	
	public Items() {
		
	}
	
	public Items(String itemNumber, String itemName) {
		this.itemName = itemName;
		this.itemNumber = itemNumber;
	}
	
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
}
