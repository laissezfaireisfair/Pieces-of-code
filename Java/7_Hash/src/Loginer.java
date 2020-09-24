import  RestrictedContainer.Container;

public class Loginer {
    public static void main(String[] args) {
        Ui UiHandler = new Ui();
        final String loginTyped = UiHandler.askLogin();
        final String passwordTyped = UiHandler.askPassword();
        final String secretText = Container.getText(loginTyped, passwordTyped);
        UiHandler.showText(secretText);
    }
}
