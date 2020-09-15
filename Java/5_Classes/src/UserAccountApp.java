import java.util.Scanner;

public class UserAccountApp {
	public static User ask_user(Scanner in) {
		System.out.println("Asking new user info.");
		System.out.print("Type name: ");
		final String firstName = in.next();

		System.out.print("Type surename: ");
		final String lastName = in.next();

		System.out.print("Type date of birth (d m y): ");
		final int birthDay = in.nextInt();
		final int birthMonth = in.nextInt();
		final int birthYear = in.nextInt();
		Date birthDate = new Date(birthDay, birthMonth, birthYear);

		System.out.print("Type email: ");
		final String email = in.next();

		return new User(firstName, lastName, birthDate, email);
	}

	public static void print_user(User user) {
		System.out.println(user.get_first_name() + " " + user.get_last_name());
		System.out.println(user.get_birth_date().toString());
		System.out.println(user.get_email());
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("How many users? ");
		final int numberUsers = in.nextInt();
		User[] users = new User[numberUsers];

		for (int i = 0; i < numberUsers; ++i)
			users[i] = ask_user(in);

		System.out.println("\nAdded users:");
		for (User user : users) {
			print_user(user);
			System.out.println("");
		}
	}
}