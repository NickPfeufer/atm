public class Account {
	private String username; 
	private int pin;
	private double balance; 

	Scanner scanner = new Scanner(System.in);

	public Account(String username, int pin, double balance) {
		this.username = username;
		this.pin = pin;
		this.balance = balance;
	}

	public String username() {
		return this.username; 
	}

	public int pin() {
		return this.pin;
	}

	public double balance() {
		return this.balance; 
	}

	public boolean modifyBalance(double change) {
		if (this.balance + change < 0) {
			return false;
		} else {
			this.balance += change; 
		}
			
	}

	public boolean modifyPin(int newPin) {
		if (newPin < 1000 && newPin > 9999) {
			return false;
		} else {
			this.pin = newPin;
		}
	}

	public boolean modifyUsername(String newusername) {
		if (newusername.Length() <= 0;) {
			return false;
		} else {
			this.username = newusername;
		}
	}
}