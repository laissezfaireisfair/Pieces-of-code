import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ui {
    private final Scanner mScanner;
    private final String mPathStr;
    public enum FileMode {READ, WRITE};

    public Ui(final String pathStr) {
        System.out.println("Hello, user!");
        mScanner = new Scanner(System.in);
        mPathStr = pathStr;
    }

    public String askLogin() {
        System.out.print("Type your login: ");
        return mScanner.nextLine();
    }

    public String askPassword() {
        System.out.print("Type your password: ");
        return mScanner.nextLine();
    }

    public String readStrFromFile() throws IOException {
        final Scanner fileScanner = new Scanner(new File(mPathStr));
        return fileScanner.nextLine();
    }

    public void printStrToFile(final String text) throws IOException {
        Path path = Paths.get(mPathStr);
        Files.write(path, text.getBytes());
    }

    public FileMode askFileMode() {
        System.out.print("Would you like to write or to read? ");
        final String input = mScanner.nextLine().toLowerCase();
        if (input.equals("read") || input.equals("r"))
            return FileMode.READ;
        if (input.equals("write") || input.equals("w"))
            return FileMode.WRITE;
        System.out.println("Wrong input. Try again.");
        return askFileMode();
    }

    public String askText() {
        System.out.println("Type your secret line:");
        return mScanner.nextLine();
    }

    public void showText(final String text) {
        System.out.println(text);
    }
}
