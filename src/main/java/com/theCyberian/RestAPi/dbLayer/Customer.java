package com.theCyberian.RestAPi.dbLayer;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	private String custId;
	private String name;
	private String intial;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String pincode;
	private String phone1;
	private String phone2;
	private String email;

	public Customer() {

	}

	public Customer(String custId, String name, String intial, String addressLine1, String addressLine2,
			String addressLine3, String pincode, String phone1, String phone2, String email) {
		super();
		this.custId = custId;
		this.name = name;
		this.intial = intial;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.pincode = pincode;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntial() {
		return intial;
	}

	public void setIntial(String intial) {
		this.intial = intial;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
