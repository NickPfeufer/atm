import java.util.Scanner;

class Atm {
	
	private Account[] users = new Account[3];
	private boolean loggedIn = false;
	private int loggedInAs;
	private boolean running = true;
	private Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		Atm justiceCat = new Atm();
	}

	public Atm(){
		// initlize acounts
		users[0] = new Account("Bob", 1234, 100.0);
		users[1] = new Account("Alice", 3333, 250);
		users[2] = new Account("JT", 0001, 999999999);

		// run interaction
		String user;
		int pin;
		int job;
		double amount;
		int fail = 0;
		while (running) {
			if (fail == 2) {
				running = false;
			}
			greeting();
			if (!loggedIn) {
				System.out.println("please enter your username");
				user = reader.next();
				System.out.println("please enter your pin number");
				pin = reader.nextInt();
				if (login(user, pin)) {
					System.out.println("Welcome back " + users[loggedInAs].username());
					running = true;
					fail = 0;
				}else {
					System.out.println("Invalid user name or pin number");
					reader.next();
					fail++;
				}
			}else{
				System.out.println("What would you like to do?");
				System.out.println("View balance    (0)");
				System.out.println("Withdraw        (1)");
				System.out.println("Deposit         (2)");
				System.out.println("Modify username (3)");
				System.out.println("Modify pin      (4)");
				System.out.println("log out         (5)");
				System.out.println("Quit            (6)");
				job = reader.nextInt();
				if (job == 0) {
					System.out.println("Your account has $" + users[loggedInAs].balance());
					
				}else if (job == 1) {
					System.out.println("Your account has $" + users[loggedInAs].balance());
					System.out.println("Please enter the amount you would like to withdraw: ");
					amount = reader.nextDouble();
					if (users[loggedInAs].modifyBalance(-amount)) {
						System.out.println("Your new balance is: " + users[loggedInAs].balance());
					}else {
						System.out.println("That is more than you have in your acount");
					}
				}else if (job == 2){
					System.out.println("Your account has $" + users[loggedInAs].balance());
					System.out.println("Please enter the amount you would like to Deposit: ");
					amount = reader.nextDouble();
					if (users[loggedInAs].modifyBalance(amount)) {
						System.out.println("Your new balance is: " + users[loggedInAs].balance());
					}else {
						System.out.println("That amount is invalid");
					}					
				}else if (job == 3){
					System.out.println("Enter your new user name");
					if (users[loggedInAs].modifyUsername(reader.next())){
						System.out.println("Your username has been updated to " + users[loggedInAs].username());
					}else {
						System.out.println("The username you entered was invalid");
					}
				}else if (job == 4){
					System.out.println("Enter your new pin number");
					if(users[loggedInAs].modifyPin(reader.nextInt())){
						System.out.println("Your pin number has been updated to " + users[loggedInAs].pin());
					}else {
						System.out.println("The number you entered was invalid");	
					}
					
				}else if (job == 5){
					System.out.println("Goodbye");
					loggedIn = false;
				}else if (job == 6){
					running = false;	
				}else {
					System.out.println("Task not found");	
				}
			}
		}
		System.out.println("Shuting down....");
	}

	public void greeting(){
		if (loggedIn == true) {
			System.out.println("User: " + users[loggedInAs].username());
		}else {
			System.out.println("Welcome, please enter your username and pin number");
		}
	}

	public boolean login(String user, int pin){
		for (int i = 0; i<users.length; i++) {
			if (users[i].username().equals(user) && users[i].pin() == pin) {
				loggedInAs = i;
				loggedIn = true;
				return true;
			}
		}
		return false;
	}
	public void logout(){
		loggedIn = false;
	}
}
