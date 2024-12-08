package project_hess;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Project_Hess {
	
	static ArrayList <Traveler> travelers = new ArrayList <Traveler>();
	static ArrayList <Flight> flights = new ArrayList <Flight>();
	static String input = "";
	
	//===================PLANNNING=================//
	
	/*
	 * WHEN WE INPUT THE FLIGHT NUMBER FROM THE **TRAVELER CLASS** 
	 * WE NEED TO ATTACH IT TO THE FLIGHT CLASS
	 * HOW DO WE DO THAT??
	 * 
	 * WE'LL NEED TO MAKE A SEARCH FLIGHT CLASS ESSENTIALLY TO MAKE IT MATCH UP
	 * AS WE ENTER THE FLIGHT NUMBER, WE'LL CALL A **CHECKFLIGHTNUMBER()** FUNCTION TO SEE IF IT MATCHES UP
	 * 
	 * SOMETHIN LIKE 
	 * FOR (INT I =0; I < INPUT.LENGTH(); I++ ){
	 * 		IF THE CHAR.AT(I) == TO THE FLIGHT NUMBER
	 * }
	 * 
	 */
	
	
	
	
	
	//===================PLANNING=================//

	
	
	//===================MAIN=================//
	

	public static void main(String[] args) {
		int menuOption = 0;
		int foundAt = -1;
		int searchNumber = 0;
		
		while (menuOption != 4) {
			menuOption = menu();
			switch(menuOption) {
				
			case 1: Traveler traveler = new Traveler();
			populateFlight();
			traveler.registerTraveler();
			travelers.add(traveler);
			findFlight();
			break;
			
			case 2: displayAllTravelers();
			break;
			
			case 3: input = JOptionPane.showInputDialog("please enter the travelers passport number you would like to search for :");
			
			searchNumber = Integer.parseInt(input);
			foundAt = searchTraveler(searchNumber);
			if (foundAt == -1) {
				JOptionPane.showMessageDialog(null, searchNumber + "was not found");
			}else {
				travelers.get(foundAt).displayTraveler();
			}
			break;
			
			case 4: JOptionPane.showMessageDialog(null,"goodbye now.");
			
			}
		}
		
		
		
//		menuOption = menu();
//		JOptionPane.showMessageDialog(null,"whats good ");
	}
	
	//===================END MAIN=================//

	//===================MENU=================//

	
	public static int menu() {
		int selection = 0;
		input = JOptionPane.showInputDialog("1-Register a traveler." + "\n" + 
											"2-Display all Travelers." + "\n" + 
											"3-Search for a Traveler." + "\n" + 
											"4-Quit Program");
		selection = Integer.parseInt(input);
		return selection;
	}
	
	//===================END MENU=================//
	
	//===================DISPLAY ALL TRAVELERS=================//



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
	}

	//===================END DISPLAY ALL TRAVELERS=================//
	
	//===================POPULATE FLIGHTS=================//


	
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
	
	//===================END POPULATE FLIGHTS=================//

	
//===================FIND FLIGHT=======================//
	
	public static void findFlight() {
	   for(int i = 0; i < travelers.size(); i++) {
		   //Traveler traveler = travelers.get(i)
		   
		   for(int j = 0; j< flights.size(); j++) {
			   //Flight flight = flights.get(j)
			   
			   if(travelers.get(i).flightNumber.equals(flights.get(j).flightNumber)) {
				   JOptionPane.showMessageDialog(null, "flight found! " + 
						   			"\nAirline : " + flights.get(j).airline +
						   			"\nCity : " + flights.get(j).city +
						   			"\nCountry : " + flights.get(j).country);
						   								
			   }
		   }//end for j
	   }//end for i
	   
	   JOptionPane.showMessageDialog(null, "no flight found!");
	}//end findFlight()

	
//===================END FIND FLIGHT=======================//
	
	
	
//===================SEARCH TRAVELER=======================//
	
	public static int searchTraveler(int searchNumber) {
		
		for(int i = 0; i < travelers.size(); i++) {
			if (searchNumber == travelers.get(i).passportNumber) {
				return i;
			}//end if search
				else {
					i++;
				}//end else
		}//end for
		return -1;
		
	}//end searchTraveler
	
//===================END SEARCH TRAVELER=======================//
	
//===================COUNT QURANTINE=======================//
	
public static void countQuarantine() {
	
}
	
//===================END COUNT QURANTINE=======================//

	
	
	
	

	
}//end class Project_Hess

//===================CLASS TRAVELER=================//


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

		while(!checkString()) {
			JOptionPane.showMessageDialog(null, "Incorrect input, please numbers asnd letters only");
			input = JOptionPane.showInputDialog("Please enter your flight number : ");
			
		}//end check string
		flightNumber = input;
		
		input = JOptionPane.showInputDialog("Please enter your passport number : ");

		while(!checkNumber()) {
			JOptionPane.showMessageDialog(null, "Incorrect input, please numbers only and must be ten digits");
			input = JOptionPane.showInputDialog("Please enter your passport number : ");
		
		}//end check number
		passportNumber = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("Please enter your first name : ");
		
		while(!checkStringName()){
			JOptionPane.showMessageDialog(null, "Incorrect input, please letters only");
			input = JOptionPane.showInputDialog("Please enter your first name : ");
			
		}//check String Name
		firstName = input;
		
		input = JOptionPane.showInputDialog("Please enter your last name : ");
		
		while(!checkStringName()){
			JOptionPane.showMessageDialog(null, "Incorrect input, please letters only");
			input = JOptionPane.showInputDialog("Please enter your last name : ");
			
		}//end check string name
		lastName = input;	
	
		input = JOptionPane.showInputDialog("Please enter your phone number : ");

		while(!checkNumber()) {
			JOptionPane.showMessageDialog(null, "Incorrect input, please numbers only and must be ten digits");
			input = JOptionPane.showInputDialog("Please enter your phone number : ");
			
		}//end check number
		phoneNumber = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("Please enter the Tempeture in fahrenheit : ");
		while(!checkTemp()) {
			JOptionPane.showMessageDialog(null, "Incorrect input, please one decimal and numbers only!");
			input = JOptionPane.showInputDialog("Please enter your temp in fahrenheit : ");
			
		}
		fahrenheit = Double.parseDouble(input);
		status = checkStatus(fahrenheit);
		
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
				else if(!Character.isDigit(input.charAt(i))) {
					return false;
				}//end if character is not a digit
		}//end for loop
		return decimal ==1;
	}//end check tempeture
	
	boolean checkStatus(double fahrenheit) {
		if (fahrenheit >= 100.4 ) {
			status = true;
			JOptionPane.showMessageDialog(null, "you are to be quarantined");
		} else {
			status = false;
			JOptionPane.showMessageDialog(null, "not to be quarantined");

		}
		return status;
		
	}
	
	void displayTraveler() {
		JOptionPane.showMessageDialog(null, "flightNumber : " + flightNumber + "\n" + 
											"passport number : " + passportNumber + "\n" +
											"first name : " + firstName + "\n" + 
											"last Name : " + lastName + "\n" + 
											"phone number :  " + phoneNumber + "\n" + 
											"fahrenheit : " + fahrenheit + "\n" + 
											"status : " + status );
	}//end display traveler
	
}//end class traveler

//===================END CLASS RTRAVELER=================//

//===================FLIGHT=================//



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

//===================END CLASS FLIGHT=================//

