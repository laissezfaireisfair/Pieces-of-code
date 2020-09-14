public class conditions {
  public static void main(String[] args) {
    if (args[0].equals("Andrey"))
      System.out.println("Hi, Andrey!");
    else if (args[0].equals("boy"))
      System.out.println("Hi, boy!");
    else
      System.out.println("Hi, girl!");

    switch (args[1]) {
      case "Met": {
        System.out.println("Nice to meet you!");
      }
      case "Sneezed": {
        System.out.println("Bless you!");
      }
      default: {
        System.out.println("I don't know what you want, sorry.");
      }
    }
  }
}
