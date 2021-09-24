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
        System.out.print("Co ile minut bot powinien sprawdzać cenę? (dozwolony zakres 10min-120min) > ");
        int minutes = scanner.nextInt();
        if (minutes < 10 || minutes > 120) {
            System.out.println("Podany zakres jest niedozwolony. Spróbuj jeszcze raz.");
            return;
        }

        Timer time = new Timer();
        AmazonBot ab = new AmazonBot(url, targetPrice);
        time.schedule(ab, 0, Utility.convertMinutesToMiliseconds(minutes));
    }
}
