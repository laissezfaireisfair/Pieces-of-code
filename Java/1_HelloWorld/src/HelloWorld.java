public class HelloWorld {
  public static void main(String[] args) {
    final Message helloWorldMessage = new Message("Hello, World!");
    System.out.println(helloWorldMessage.get_text());
  }
}
