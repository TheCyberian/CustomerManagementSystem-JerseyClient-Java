package com.theCyberian.RestAPi.dbLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseAccessLayer {
	static Connection connection;
	static ResultSet resultSet;
	static Statement statement;

	public DatabaseAccessLayer() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(
					"jdbc:sqlite:/home/utkarsh/eclipse-workspace/RestAPi/src/main/resources/databaseLocal/Test.db");
			statement = connection.createStatement();
			System.out.println("[INFO] Successfully connected to the DB.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String[]> getCustomerDataFromDb() {
		ArrayList<String[]> arrayList = new ArrayList<String[]>();
		try {
			resultSet = statement.executeQuery("SELECT * FROM customer");
			ResultSetMetaData rsmd = resultSet.getMetaData();

			int columnsNumber = rsmd.getColumnCount();

			while (resultSet.next()) {
				String[] arrayOfCustomerData = new String[columnsNumber];
				for (int i = 1; i <= columnsNumber; i++) {
					arrayOfCustomerData[i - 1] = resultSet.getString(i).toString();

				}
				arrayList.add(arrayOfCustomerData);
			}
			return arrayList;
		} catch (Exception e) {
			e.printStackTrace();
			return arrayList;
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String[]> getItemsDataFromDb() {

		ArrayList<String[]> arrayList = new ArrayList<String[]>();
		try {
			resultSet = statement.executeQuery("SELECT * FROM itemDetails");
			ResultSetMetaData rsmd = resultSet.getMetaData();

			int columnsNumber = rsmd.getColumnCount();

			while (resultSet.next()) {
				String[] arrayOfItemsData = new String[columnsNumber];
				for (int i = 1; i <= columnsNumber; i++) {
					arrayOfItemsData[i - 1] = resultSet.getString(i).toString();

				}
				arrayList.add(arrayOfItemsData);
			}
			return arrayList;
		} catch (Exception e) {
			e.printStackTrace();
			return arrayList;
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public ArrayList<String> getCustomerDataFromDb(String custId) {

		ArrayList<String> arrayOfCustomerData = new ArrayList<String>();

		try {
			resultSet = statement.executeQuery("SELECT * FROM customer WHERE custId = '" + custId + "'");
			ResultSetMetaData rsmd = resultSet.getMetaData();

			int columnsNumber = rsmd.getColumnCount();

			while (resultSet.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					arrayOfCustomerData.add(resultSet.getString(i).toString());
					System.out.println(resultSet.getString(i).toString());
				}
			}
			return arrayOfCustomerData;
		} catch (Exception e) {
			e.printStackTrace();
			return arrayOfCustomerData;
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String> getItemDataFromDb(String itemId) {

		ArrayList<String> arrayOfItemsData = new ArrayList<String>();

		try {
			resultSet = statement.executeQuery("SELECT * FROM itemDetails WHERE itemNumber = '" + itemId + "'");
			ResultSetMetaData rsmd = resultSet.getMetaData();

			int columnsNumber = rsmd.getColumnCount();

			while (resultSet.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					arrayOfItemsData.add(resultSet.getString(i).toString());
					System.out.println(resultSet.getString(i).toString());
				}
			}
			return arrayOfItemsData;
		} catch (Exception e) {
			e.printStackTrace();
			return arrayOfItemsData;
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void addItemsToTable(Items item) {
		try {
			statement.executeUpdate("INSERT INTO itemDetails(itemName) VALUES ('" + item.getItemName() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
//				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void addCustomerToTable(Customer customer) {
		try {
			String queryString = "INSERT INTO customer(name, initial, address1, address2, address3, pincode, phone1, phone2, email) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
			String query = String.format(queryString, customer.getName(), customer.getIntial(),
					customer.getAddressLine1(), customer.getAddressLine2(), customer.getAddressLine3(),
					customer.getPincode(), customer.getPhone1(), customer.getPhone2(), customer.getEmail());

			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
//				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
