package project_hess;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Project_Hess {
	
	static ArrayList <Traveler> travelers = new ArrayList <Traveler>();
	static ArrayList <Flight> flights = new ArrayList <Flight>();
	static String input = "";
	

	public static void main(String[] args) {
		int menuOption = 0;
		
		while (menuOption != 4) {
			menuOption = menu();
			switch(menuOption) {
				
			case 1: Traveler traveler = new Traveler();
			traveler.registerTraveler();
			travelers.add(traveler);
			break;
			
			case 2: displayAllTravelers();
			break;
			
			}
		}
		
		
		
		menuOption = menu();
		JOptionPane.showMessageDialog(null,"whats good ");
	}//end main
	
	public static int menu() {
		int selection = 0;
		input = JOptionPane.showInputDialog("1-Register a traveler." + "\n" + 
											"2-Display all Travelers." + "\n" + 
											"3-Search for a Traveler." + "\n" + 
											"4-Quit Program");
		selection = Integer.parseInt(input);
		return selection;
	}//end menu

	public static void displayAllTravelers() {
		for(int i = 0; i < travelers.size(); i++) {
			
		JOptionPane.showMessageDialog(null, "flightNumber " + travelers.get(i).flightNumber + "\n" + 
				"passport number " + travelers.get(i).passportNumber + "\n" +
				"first name " + travelers.get(i).firstName + "\n" + 
				"last Name " + travelers.get(i).lastName + "\n" + 
				"phone number :  " + travelers.get(i).phoneNumber + "\n" + 
				"fahrenheit " + travelers.get(i).fahrenheit + "\n" + 
				"status " + travelers.get(i).status );
		}
	}//end display travelers
	
	public static void populateFlight() {
		Flight flight = new Flight("686Q","Virgin", "London", "UK");
		flights.add(flight);
		Flight flight2 = new Flight("3228","Alitalia", "Rome", "IT");
		flights.add(flight2);
		Flight flight3 = new Flight("951","America", "San Paolo", "BR");
		flights.add(flight3);
		Flight flight4 = new Flight("7669","AeroMexico", "Mexico City", "MX");
		flights.add(flight4);
		Flight flight5 = new Flight("AT200","Royal Air Maroc", "Casablanca", "MA");
		flights.add(flight5);
		Flight flight6 = new Flight("1078","Air China", "Beijing", "CN");
		flights.add(flight6);
		}
	
}//end class Project_Hess

class Traveler {
	
	static String input = "";
	
	String flightNumber;
	int passportNumber;
	String firstName;
	String lastName;
	int phoneNumber;
	double fahrenheit;
	boolean status;
	
	Traveler(){
		flightNumber = "";
		passportNumber = 0;
		firstName = "";
		lastName = "";
		phoneNumber = 0;
		fahrenheit = 0.0;
		status = false;
	}//no constructors
	
	Traveler(String flightNumber, int passportNumber, String firstName, String lastName, int phoneNumber, double fahrenheit,boolean status){
		this.flightNumber = flightNumber;
		this.passportNumber = passportNumber;
		this.firstName = firstName;
		this.lastName  = lastName;
		this.phoneNumber = phoneNumber;
		this.fahrenheit = fahrenheit;
		this.status = status;
		
		
	}//constructors
	
	void registerTraveler() {
		
		input = JOptionPane.showInputDialog("Please enter your flight number : ");
		checkString();
		while(!checkString()) {
			JOptionPane.showMessageDialog(null, "Incorrect input, please numbers asnd letters only");
			input = JOptionPane.showInputDialog("Please enter your flight number : ");
			checkString();
		}//end check string
		flightNumber = input;
		
		input = JOptionPane.showInputDialog("Please enter your passport number : ");
		checkNumber();
		while(!checkNumber()) {
			JOptionPane.showMessageDialog(null, "Incorrect input, please numbers only and must be ten digits");
			input = JOptionPane.showInputDialog("Please enter your passport number : ");
			checkNumber();
		}//end check number
		passportNumber = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("Please enter your first name : ");
		checkStringName();
		while(!checkStringName()){
			JOptionPane.showMessageDialog(null, "Incorrect input, please letters only");
			input = JOptionPane.showInputDialog("Please enter your first name : ");
			checkStringName();
		}//check String Name
		firstName = input;
		
		input = JOptionPane.showInputDialog("Please enter your last name : ");
		checkStringName();
		while(!checkStringName()){
			JOptionPane.showMessageDialog(null, "Incorrect input, please letters only");
			input = JOptionPane.showInputDialog("Please enter your first name : ");
			checkStringName();
		}//end check string name
		lastName = input;	
	
		input = JOptionPane.showInputDialog("Please enter your phone number : ");
		checkNumber();
		while(!checkNumber()) {
			JOptionPane.showMessageDialog(null, "Incorrect input, please numbers only and must be ten digits");
			input = JOptionPane.showInputDialog("Please enter your phone number : ");
			checkNumber();
		}//end check number
		phoneNumber = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("Please enter the Tempeture in fahrenheit : ");
		checkTemp();
		while(!checkTemp()) {
			JOptionPane.showMessageDialog(null, "Incorrect input, please one decimal and numbers only!");
			input = JOptionPane.showInputDialog("Please enter your temp in fahrenheit : ");
			checkNumber();
		}
		fahrenheit = Double.parseDouble(input);
		
	}//end register Traveler
	
	boolean checkString() {
		for(int i = 0; i < input.length(); i++) {
			if (!Character.isLetter(input.charAt(i)) && !Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}//end check String
	
	boolean checkStringName() {
		for(int i = 0; i < input.length(); i++) {
			if (!Character.isLetter(input.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}//end check String
	
	boolean checkNumber() {
		if(input.length() != 10) {
			return false;
		} else {
		for(int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				return false;
				}
			}
		}
		return true;
	}//end check Number
	
	boolean checkTemp() {
		int decimal = 0;
		//we'll have to check loop throuyght the strongm, and cehck if the character at 0 is a number, if character at 1 is a decimal, and haracter and 3 is a number
		for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '.') {
				decimal++;
					if(decimal > 1) {
					return false;
				}//end if decmal if greater than 1
			}//end if chat at i is a decimal
				else if(Character.isDigit(input.charAt(i))) {
					return false;
				}//end if character is not a digit
		}//end for loop
		return true;
	}//end check tempeture
	
	void displayTraveler() {
		JOptionPane.showMessageDialog(null, "flightNumber " + flightNumber + "\n" + 
											"passport number " + passportNumber + "\n" +
											"first name " + firstName + "\n" + 
											"last Name " + lastName + "\n" + 
											"phone number :  " + phoneNumber + "\n" + 
											"fahrenheit " + fahrenheit + "\n" + 
											"status " + status );
	}//end display traveler
	
}//end class traveler

class Flight{
	String flightNumber;
	String airline;
	String city;
	String country;
	
	Flight(){
		flightNumber = "";
		airline = "";
		city = "";
		country = "";
	}//end without arguments
	
	Flight(String flightNumber, String airline, String city, String country){
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.city = city;
		this.country = country;
		
	}//end w arguments
	
}
