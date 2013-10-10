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

		while (running) {
			greeting();
			if (!loggedIn) {
				System.out.println("please enter your username");
				user = reader.next(java.lang.String);
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
			}
		}
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