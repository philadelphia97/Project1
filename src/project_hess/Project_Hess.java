package project_hess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Project_Hess {
	
	static ArrayList <Traveler> travelers = new ArrayList <Traveler>();
	static ArrayList <Flight> flights = new ArrayList <Flight>();
	static String input = "";
	
	

	
	
	//===================MAIN=================//
	

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
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
			
			case 4: displayQuarantinedTravelers();
			
			JOptionPane.showMessageDialog(null, "press OK to write all files to a file - ");
			try(FileOutputStream outFile = new FileOutputStream("travelers");
					ObjectOutputStream outObject = new ObjectOutputStream(outFile)) {
				for (Traveler t : travelers) {
					outObject.writeObject(t);
				}//end for
			}//end output stream
			
			JOptionPane.showMessageDialog(null, "hit ok to read all records from file - ");
			try (FileInputStream inFile = new FileInputStream("travelers");
					ObjectInputStream inObject = new ObjectInputStream(inFile)) {
				ArrayList <Traveler> readTravelerList = new ArrayList <Traveler>();
				while (inFile.available() > 0) {
					Traveler readTraveler = (Traveler) inObject.readObject();
					readTravelerList.add(readTraveler);
				}
				JOptionPane.showMessageDialog(null, "Hit ok to display records - ");
				for (Traveler t : readTravelerList) {
					t.displayTraveler();
				}
			}
			
			
			
			
			
				JOptionPane.showMessageDialog(null,"goodbye now.");
			
			}//end switch menu
		}//end while menu
		
		
		
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
	
	
	
	//===================DISPLAY QUARANTINED TRAVELERS=================//
	
	public static void displayQuarantinedTravelers() {
		for(int i = 0; i < travelers.size(); i ++) {
			if (travelers.get(i).status == true) {
				JOptionPane.showMessageDialog(null, "Travelers that need to be quarantined : ");
				travelers.get(i).displayTraveler();
			} else {
				JOptionPane.showMessageDialog(null, "no travelers need to be quarentined");
			}
		}//end for
	}//end method
	
	
	
	//===================END DISPLAY QUARANTINED TRAVELERS=================//
	
	

	
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
	

	
	
	
	

	
}//end class Project_Hess

//===================CLASS TRAVELER=================//


class Traveler implements Serializable {
	
	private static final long serialVersionUID = 1L;

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

