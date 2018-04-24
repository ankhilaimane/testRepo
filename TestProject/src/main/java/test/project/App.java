package test.project;

/**
 *
 *
 */
public class App {
  public static void main(String[] args) throws Exception {
    try {
      if (args.length > 0) {
        String chaine = args[0];
        if (chaine.length() > 0) {
          System.out.println("Bonjour " + chaine + " ");
          System.out.println(HTTPClient.GET(chaine));
          // System.out.println(HTTPClient.getResult(chaine));
          System.out.println(HTTPClient.getVersion(chaine));

        }
      } else {
        System.out.println("Hello !!");
      }
    } finally {
      System.out.println("Fin!");
    }
  }
}
