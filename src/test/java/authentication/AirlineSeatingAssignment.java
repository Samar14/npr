package authentication;

import java.util.Scanner;

public class AirlineSeatingAssignment {
	// Assign Seats on an airplane
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		SeatAvailability seatAvailability = new SeatAvailability();
		// ask for preference
		System.out.println("Would you like a business ticket or economy?");
		System.out.println("ENter business or economy.");
		String pref = scanner.nextLine();

		// if business
		if (pref.equalsIgnoreCase("business")) {
			// check if any business seat is available
			if (seatAvailability.isBusinessAvailable()) {
				// if available
				// assign the seat
				seatAvailability.printNextBusinessSeat();
			} else {
				// else if not available and economy is available
				if (seatAvailability.isEconomyAvailable()) {
					System.out.println("Would you like to fly economy instead?");
					System.out.println("Enter yes or no.");
					// ask for change
					String answer = scanner.nextLine();
					// if yes
					if (answer.equalsIgnoreCase("yes")) {
						// assign seat
						seatAvailability.printNextEconomySeat();
					} else {
						System.out.println("We apoligize for the inconvineice. ");
					}
					// else if no seat is available on any class
					// say have a nice day
				} else {
					System.out.println("We apoligize for the inconvineice. ");
				}
			}
			// else if not available and economy is not available
			// say have a nice day
		}

		else {
			// check if any economy seat is available
			if (seatAvailability.isEconomyAvailable()) {
				seatAvailability.printNextEconomySeat();
			} else {
				if (seatAvailability.isBusinessAvailable()) {
					System.out.println("Would you like to fly business instead?");
					System.out.println("Enter yes or no.");
					String answer = scanner.nextLine();
					if (answer.equalsIgnoreCase("yes")) {
						seatAvailability.printNextBusinessSeat();
					} else {
						System.out.println("sorry");
					}
				} else {
					System.out.println("sorry");
				}
			}
			// if available
			// assign the seat
			// else if not available and business is available
			// ask for change
			// if yes
			// assign seat
			// else
			// say have a nice day
			// else if not available and business is not available
			// say have a nice day
		}

	}

}
