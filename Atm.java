import java.util.Scanner;

class Atm {
	
	private Acount[] users = new Acount[3];
	private boolean loggedIn = false;
	private int loggedInAs;
	private boolean running = true;
	private Scanner reader = new Scanner(System.in);

	public Atm(){
		// initlize acounts
		users[0] = new Acount("Bob", 1234, 100.0);
		users[1] = new Acount("Alice", 3333, 250);
		users[2] = new Acount("JT", 0001, 999999999);

		// run interaction
		String user;
		int pin;
		int job;
		double amount;
		while (running) {
			greeting();
			if (!loggedIn) {
				System.out.println("please enter your username");
				user = reader.next(java.lang.String);
				System.out.println("please enter your pin number");
				pin = reader.nextInt();
				if (login(user, pin)) {
					System.out.println("Welcome back " + users[loggedInAs].username());

				}else {
					System.out.println("invalid user name");
					reader.next();
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
					if (modifyBalance(-amount)) {
						System.out.println("Your new balance is: " + users[loggedInAs].balance());
					}else {
						System.out.println("That is more than you have in your acount");
					}
				}else if (job == 2){
					System.out.println("Your account has $" + users[loggedInAs].balance());
					System.out.println("Please enter the amount you would like to Deposit: ");
					amount = reader.nextDouble();
					if (modifyBalance(amount)) {
						System.out.println("Your new balance is: " + users[loggedInAs].balance());
					}else {
						System.out.println("That is more than you have in your acount");
					}					
				}else if (job == 3){
					System.out.println("Enter your new user name");
					if (modifyUsername(reader.next(java.lang.String))){
						System.out.println("Your username has been updated to " + users[loggedInAs].username());
					}else {
						System.out.println("The username you entered was invalid");
					}
				}else if (job == 4){
					System.out.println("Enter your new pin number");
					
				}else if (job == 5){
					
				}else if (job == 6){
					running = false;	
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
			if (users[i].username() == user && users[i].pin() == pin) {
				loggedInAs = i;
				loggedIn = true;
				return true;
			}
		}
	}
	public void logout(){
		loggedIn = false;
	}
}
