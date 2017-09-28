package customer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Cafe {
	private static int cook[] = {0, 0, 0, 0};
	private static int cookLastEngaged[] = {0, 0, 0, 0};
	
//	private static int getTimeInSeconds() {
//		SimpleDateFormat sdf = new SimpleDateFormat("ss");
//		String str = sdf.format(new Date());
//		System.out.println("HH:mm:ss = " + str);
//	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		int totalAmount = 0;
		int butterBread = 30, gingerBread = 40, cheeseBread = 50, sweetBread = 60; //Appetizers
		int appetizer = 5;
		int chickenSoup = 180, cornSoup = 140; //Soups
		int soup = 5;
		int zingerBurger = 280, fishBurger = 390, plainBurger = 220,
		spicyBurger = 210, cheeseBurger = 250, tikkaBurger = 270; //Main Dishes
		int mainDish = 10;
		int hotWing = 40, chickenShashlick = 200, clubSandwich = 170; //Side Dishes
		int sideDish = 7;
		int t;
		String order = "";
		
		Cafe food = new Cafe();
//		getTimeInSeconds();
		
		System.out.println("______ E-Cafe ______");
		System.out.println("\n");
		System.out.println("Enter your choice number to select food.");
		do{
			System.out.println("\tItem" + "\t\tPrice");
			System.out.println("\n--Appetizers--");
			System.out.println("1.  Butter Bread" + "\t" + butterBread);
			System.out.println("2.  Ginger Bread" + "\t" + gingerBread);
			System.out.println("3.  Cheese Bread" + "\t" + cheeseBread);
			System.out.println("4.  Sweet Bread" + "\t\t" + sweetBread);

			System.out.println("\n--Soups--");
			System.out.println("5.  Chicken Soup" + "\t" + chickenSoup);
			System.out.println("6.  Corn Soup" + "\t\t" + cornSoup);
			
			System.out.println("\n--Main Course Dishes--");
			System.out.println("7.  Zinger Burger" + "\t" + zingerBurger);
			System.out.println("8.  Fish Burger" + "\t\t" + fishBurger);
			System.out.println("9.  Plain Burger" + "\t" + plainBurger);
			System.out.println("10. Spicy Burger" + "\t" + spicyBurger);
			System.out.println("11. Cheese Burger" + "\t" + cheeseBurger);
			System.out.println("12. Tikka Burger" + "\t" + tikkaBurger);


			System.out.println("\n--Side Dishes--");
			System.out.println("13.  Hot Wing" + "\t\t" + hotWing);
			System.out.println("14.  Chicken Shashlick" + "\t" + chickenShashlick);
			System.out.println("15.  Club Sandwich" + "\t" + clubSandwich);
			System.out.println("\n0. Finish Order");
			
			int choice = input.nextInt();
			switch(choice){
				case 0:
					quit = true;
					break;

				case 1:
					System.out.println("Butter Bread" + "\t" + butterBread + "\n");
					totalAmount = totalAmount + butterBread;
					order = order.concat("Butter Bread" + "\t" + butterBread + "\n");
					food.timeEsstimate(appetizer);
					break;

				case 2:
					System.out.println("Ginger Bread" + "\t" + gingerBread);
					totalAmount = totalAmount + gingerBread;
					order = order.concat("Ginger Bread" + "\t" + gingerBread + "\n");
					food.timeEsstimate(appetizer);
					break;

				case 3:
					System.out.println("Cheese Bread" + "\t" + cheeseBread);
					totalAmount = totalAmount + cheeseBread;
					order = order.concat("Cheese Bread" + "\t" + cheeseBread + "\n");
					food.timeEsstimate(appetizer);
					break;

				case 4:
					System.out.println("Sweet Bread" + "\t" + sweetBread);
					totalAmount = totalAmount + sweetBread;
					order = order.concat("Sweet Bread" + "\t" + sweetBread + "\n");
					food.timeEsstimate(appetizer);
					break;

				case 5:
					System.out.println("Chicken Soup" + "\t" + chickenSoup);
					totalAmount = totalAmount + chickenSoup;
					order = order.concat("Chicken Soup" + "\t" + chickenSoup + "\n");
					food.timeEsstimate(soup);
					break;

				case 6:
					System.out.println("Corn Soup" + "\t" + cornSoup);
					totalAmount = totalAmount + cornSoup;
					order = order.concat("Corn Soup" + "\t" + cornSoup + "\n");
					food.timeEsstimate(soup);
					break;

				case 7:
					System.out.println("Zinger Burger" + "\t" + zingerBurger);
					totalAmount = totalAmount + zingerBurger;
					order = order.concat("Zinger Burger" + "\t" + zingerBurger + "\n");
					food.timeEsstimate(mainDish);
					break;

				case 8:
					System.out.println("Fish Burger" + "\t" + fishBurger);
					totalAmount = totalAmount + fishBurger;
					order = order.concat("Fish Burger" + "\t" + fishBurger + "\n");
					food.timeEsstimate(mainDish);
					break;

				case 9:
					System.out.println("Plain Burger" + "\t" + plainBurger);
					totalAmount = totalAmount + plainBurger;
					order = order.concat("Plain Burger" + "\t" + plainBurger + "\n");
					food.timeEsstimate(mainDish);
					break;

				case 10:
					System.out.println("Spicy Burger" + "\t" + spicyBurger);
					totalAmount = totalAmount + spicyBurger;
					order = order.concat("Spicy Burger" + "\t" + spicyBurger + "\n");
					food.timeEsstimate(mainDish);
					break;

				case 11:
					System.out.println("Cheese Burger" + "\t" + cheeseBurger);
					totalAmount = totalAmount + cheeseBurger;
					order = order.concat("Cheese Burger" + "\t" + cheeseBurger + "\n");
					food.timeEsstimate(mainDish);
					break;

				case 12:
					System.out.println("Tikka Burger" + "\t" + tikkaBurger);
					totalAmount = totalAmount + tikkaBurger;
					order = order.concat("Tikka Burger" + "\t" + tikkaBurger + "\n");
					food.timeEsstimate(mainDish);
					break;

				case 13:
					System.out.println("Hot Wing" + "\t" + hotWing);
					totalAmount = totalAmount + hotWing;
					order = order.concat("Hot Wing" + "\t" + hotWing + "\n");
					food.timeEsstimate(sideDish);
					break;

				case 14:
					System.out.println("Chicken Shashlick" + "\t" + chickenShashlick);
					totalAmount = totalAmount + chickenShashlick;
					order = order.concat("Chicken Shashlick" + "\t" + chickenShashlick + "\n");
					food.timeEsstimate(sideDish);
					break;

				case 15:
					System.out.println("Club Sandwich" + "\t" + clubSandwich);
					totalAmount = totalAmount + clubSandwich;
					order = order.concat("Club Sandwich" + "\t" + clubSandwich + "\n");
					food.timeEsstimate(sideDish);
					break;

				default:
					System.out.println("Wrong input");
			}
		}while(!quit);

		System.out.println("\nYour Order:\n" + order);
		System.out.println("Total bill amount = " + totalAmount);
		System.out.println("Thanks for visiting E-Cafe. Hope you will come again.");
	}

	private void timeEsstimate(int t) {
		int second, minute, hour, m = 0, h = 0, s = 0;
		GregorianCalendar date = new GregorianCalendar();
		second = date.get(Calendar.SECOND);
		minute = date.get(Calendar.MINUTE);
		hour = date.get(Calendar.HOUR);
		System.out.println("Current time: " + hour + ":" + minute + ":" + second);
		if(hour <= 11 || hour >= 22) System.out.println("Cafe is closed.");
		else {
			s = second + (60 * minute) + (3600 * hour);
			s = s + cookScheduler(t);
			if(s >=  3600) { h = s / 3600; s -=  h * 3600; }
			if(s >=  60) { m = s / 60; s -=  m * 60; }
			System.out.println("Your order will be ready at "+ h + ":" + m + ":" + s );
		}
	}
	
	private static int cookScheduler(int t) {
		GregorianCalendar date = new GregorianCalendar();
		int s = date.get(Calendar.SECOND) + (60 * date.get(Calendar.MINUTE)) + (3600 * date.get(Calendar.HOUR));
		t *= 60;
		for(int i = 0; i < 4; i++) {
			if ((cook[i] + t) <= (30*60) && cook[i] > 0) {
				cook[i] -= cookLastEngaged[i] - s;
				cook[i] += t;
				cookLastEngaged[i] = s;
//				System.out.println("Order will be prepared by cook" + (i+1));
				return cook[i];
			}
//			else System.out.println("Cook " + (i+1) + " is too busy to take this order");
		}
		return 0;
	}
	
} // End Class Cafe