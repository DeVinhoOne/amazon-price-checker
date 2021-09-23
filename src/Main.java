import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Download amazon webpage and check price for OnePlus 9 Pro (smartphone).
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPodaj link do produktu na Amazon.pl");
        final String url = scanner.nextLine();
        System.out.println("Podaj cenę, o której marzysz.");
        final double targetPrice = scanner.nextDouble();
        new AmazonBot(url, targetPrice).run();
    }
}
