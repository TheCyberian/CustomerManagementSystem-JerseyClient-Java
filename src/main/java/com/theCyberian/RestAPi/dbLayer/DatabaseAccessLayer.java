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

//	public static void main(String args[]) {
//		DatabaseAccessLayer obj = new DatabaseAccessLayer();
//		System.out.println(obj.getCustomerDataFromDb());
//	}
}
