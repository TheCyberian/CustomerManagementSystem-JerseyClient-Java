package com.theCyberian.RestAPi.dbLayer;

public class Orders {
	private String orderId;
	private String custId;
	private String itemNumber;
	private String amountPaid;
	private String amountDue;
	private String totalAmount;

	public Orders(String orderId, String custId, String itemNumber, String amountPaid, String amountDue,
			String totalAmount) {
		super();
		this.orderId = orderId;
		this.custId = custId;
		this.itemNumber = itemNumber;
		this.amountPaid = amountPaid;
		this.amountDue = amountDue;
		this.totalAmount = totalAmount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(String amountDue) {
		this.amountDue = amountDue;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

}
