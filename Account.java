public class Account {
	private String username; 
	private int pin;
	private double balance; 


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
		return true;
			
	}

	public boolean modifyPin(int newPin) {
		if (newPin <= 1000 || newPin >= 9999) {
			return false;
		} else {
			this.pin = newPin;
		}
		return true;
	}

	public boolean modifyUsername(String newusername) {
		if (newusername.length() <= 0) {
			return false;
		} else {
			this.username = newusername;
		}
		return true;
	}
}
