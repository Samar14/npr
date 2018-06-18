package authentication;

public class SeatAvailability {

	private boolean[] business = new boolean[5];
	// [false][false][false][false][false]
	private boolean[] economy = new boolean[20];
	private int avaiBuss;
	private int avaiEco;

	public boolean isBusinessAvailable() {
		for (int i = 0; i < business.length; i++) {
			// if there is a seat
			if (business[i] == false) {
				// say yes
				avaiBuss = i + 1;
				return true;
			}
		}
		return false;
	}

	public boolean isEconomyAvailable() {
		for (int i = 0; i < economy.length; i++) {
			// if there is a seat
			if (economy[i] == false) {
				// say yes
				avaiEco = i + 1;
				return true;
			}
		}
		return false;
	}

	public void printNextBusinessSeat() {
		// avaiBuss = 3
		System.out.println("You seat number is " + avaiBuss);
		int rem = avaiBuss % 4;
		switch (rem) {
		case 1:
			System.out.println("1A");
			break;

		default:
			break;
		}

	}

	public void printNextEconomySeat() {
		
		// similar login form above , but getting the rownuer is extra
	}

}
