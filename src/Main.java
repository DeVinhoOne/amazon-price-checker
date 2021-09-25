import util.Utility;

import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPodaj link do produktu na Amazon.pl > ");
        final String url = scanner.nextLine();
        System.out.print("Podaj cenę (w ZŁ) > ");
        final double targetPrice = scanner.nextDouble();
        System.out.print("Co ile minut bot powinien sprawdzać cenę? > ");
        int minutes = scanner.nextInt();
        Timer time = new Timer();
        AmazonBot ab = new AmazonBot(url, targetPrice);
        time.schedule(ab, 0, Utility.convertMinutesToMiliseconds(minutes));
    }
}
