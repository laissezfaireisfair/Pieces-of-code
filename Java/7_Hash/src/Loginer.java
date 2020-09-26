import  RestrictedContainer.Container;

import java.io.IOException;

public class Loginer {
    private static void write(final Ui ui, final int loginHash, final int passwordHash) throws IOException {
        final String text = ui.askText();
        Container container = new Container(loginHash, passwordHash, text);
        ui.printStrToFile(container.getEncrypted());
    }

    private static void read(final Ui ui, final int loginHash, final int passwordHash) {
        Container container = new Container(ui.readStrFromFile());
        ui.showText(container.getText(loginHash, passwordHash));
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("You need to type file name when calls");
            return;
        }
        final String path = args[0];
        Ui ui = new Ui(path);
        final Ui.FileMode mode = ui.askFileMode();
        final int loginHash = ui.askLogin().hashCode();
        final int passwordHash = ui.askPassword().hashCode();
        try {
            if (mode == Ui.FileMode.READ) {
                read(ui, loginHash, passwordHash);
            } else {
                write(ui, loginHash, passwordHash);
            }
        }
        catch(IOException e){
            System.out.println("Sorry, input failed. " + e.getMessage());
        }
    }
}
