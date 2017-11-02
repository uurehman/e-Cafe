package code;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Cafe {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("______ E-Cafe ______");
		System.out.println("\n");

		// set connection parameters
		String host = "localhost";
		int portNum = 3306;
		String dbNAme = "ecafe";
		String user = "root";
		String password = "seecs";

		// making objects
		Statement statement;
		Connection connection;
		ResultSet rs;

		// Load DB-Specific Database Driver
		Class.forName("com.mysql.jdbc.Driver");

		// setting connection
		connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + portNum + "/" + dbNAme, user, password);
		statement = connection.createStatement();
		String query = "SELECT * FROM items";
		rs = statement.executeQuery(query);

		boolean quit = false;
		int totalAmount = 0; // total cost of the order
		Scanner input = new Scanner(System.in); // get user input to select items in order
		ArrayList itemsList = new ArrayList();
		System.out.println("\t\t\tMenu\n#\t| Name\t\t| Price\t|Time\t| Item Type");
		System.out.println("---------------------------------------------------");
		do {
			showMenu(rs); // display menu to the user
			int choice = input.nextInt();
			if (choice == 0)
				quit = true;
			else if (choice <= 15 && choice > 0)
				itemsList.add(choice);
			else
				System.out.println("ERROR: Invalid number entered.");
		} while (!quit);

		System.out.println(itemsList);

		String deliveryDetails = "", currTime = "", readyTime = "", address = "";
		GregorianCalendar date = new GregorianCalendar();
		System.out
				.println("How would you like to get your order?\n1. Take away\n2. Home Delivery\n\\nEnter your choice");
		int userInput = input.nextInt();
		switch (userInput) {
		case 1:
			deliveryDetails = "Take Away";
			System.out.println("Enter the time (in minutes) when you want to pick your order.");
			userInput = input.nextInt();
			if (userInput < 15) {
				System.out.println("Minimum time for cooking is 15 min.");
				userInput = 15;
			}

			currTime = date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
			readyTime = estimateTime(userInput);
			break;
		case 2:
			deliveryDetails = "Home delivery";
			System.out.println("Enter the address you want your order to be delivered.");
			Scanner lineInput = new Scanner(System.in);
			address = lineInput.nextLine();

			estimateTime(30);
			currTime = date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
			readyTime = estimateTime(30);
			break;
		default:
			System.out.println("ERROR: Invalid choice entered.");
		}
		// calculate Bill Price
		Iterator iterator = itemsList.iterator();
		while (iterator.hasNext()) {
			query = "SELECT price FROM `items` WHERE id = " + iterator.next();
			rs = statement.executeQuery(query);
			if (rs.next())
				totalAmount += rs.getInt(1);
		}
		System.out.println("total amount: " + totalAmount);

		// Save order in database
		query = "INSERT INTO `orders` (delivery_details, curr_time, address,  delivery_time, bill_price) VALUES ('"
				+ deliveryDetails + "', '" + currTime + "', '" + address + "', '" + readyTime + "', " + totalAmount
				+ " );";
		int updateResult = statement.executeUpdate(query);

		// if (updateResult > 0) {
		// System.out.println("SUCCESS: order updated.");
		// }

		// access the id of newly updated row in orders table
		query = "SELECT id FROM `orders`;";
		rs = statement.executeQuery(query);
		int lastRowId = 0;
		while (rs.next()) {
			lastRowId = rs.getInt(1);
		}
		// updateLog(statement, "order insert", currTime, "order", lastRowId);

		// save order details in database
		iterator = itemsList.iterator();
		while (iterator.hasNext()) {
			query = "INSERT INTO `order_dertails` (items_id, orders_id) VALUES (" + iterator.next() + ", " + lastRowId
					+ ")";
			updateResult = statement.executeUpdate(query);

			// access the id of newly updated row in table
			/*
			 * query = "SELECT id FROM `order_dertails`;"; rs =
			 * statement.executeQuery(query); lastRowId = 0; while (rs.next()) lastRowId =
			 * rs.getInt(1); updateLog(statement, "order detail insert",
			 * date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" +
			 * date.get(Calendar.SECOND), "order_details", lastRowId);
			 */
		}

		System.out.println("Thanks for visiting E-Cafe. Hope you will come again.");
	}

	public static int updateLog(Statement statement, String eventDes, String time, String affectedTable,
			int affectedRow) throws SQLException {
		String query = "INSERT INTO `logs` (event_des, time, affected_table, affected_row) VALUES ('" + eventDes
				+ "', '" + time + "', '" + affectedTable + "', " + affectedRow + ");";
		int updateResult = statement.executeUpdate(query);
		return updateResult;
	}

	public static void showMenu(ResultSet rs) {
		
		try {
			while (rs.next()) {
				int itemId = rs.getInt(1);
				String itemName = rs.getString(2);
				int itemPrice = rs.getInt(3);
				int timeReq = rs.getInt(4);
				String itemType = rs.getString(5);
				System.out.println(
						itemId + "\t| " + itemName + "\t| " + itemPrice + "\t| " + timeReq + "\t| " + itemType);
			}
			System.out.println("---------------------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Enter the item number to select. (0. Finish Order)");
	}

	public static String estimateTime(int t) {
		int second, minute, hour, m = 0, h = 0, s = 0;
		GregorianCalendar date = new GregorianCalendar();
		second = date.get(Calendar.SECOND);
		minute = date.get(Calendar.MINUTE);
		hour = date.get(Calendar.HOUR);
		System.out.println("Current time: " + hour + ":" + minute + ":" + second);
		// if(hour <= 11 || hour >= 22) System.out.println("Cafe is closed.");
		// else {
		s = second + (60 * minute) + (3600 * hour);
		s = s + (t * 60);
		if (s >= 3600) {
			h = s / 3600;
			s -= h * 3600;
		}
		if (s >= 60) {
			m = s / 60;
			s -= m * 60;
		}
		String orderReady = h + ":" + m + ":" + s;
		System.out.println("Your order will be ready at " + orderReady);
		// }
		return orderReady;
	}

} // End Class Cafe
