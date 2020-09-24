import java.util.Scanner;

public class Ui {
    private final Scanner mScanner;

    public Ui() {
        System.out.println("Hello, user!");
        mScanner = new Scanner(System.in);
    }

    public String askLogin() {
        System.out.print("Type your login: ");
        return mScanner.nextLine();
    }

    public String askPassword() {
        System.out.print("Type your password: ");
        return mScanner.nextLine();
    }

    public void showText(final String text) {
        System.out.println(text);
    }
}
