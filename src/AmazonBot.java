import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;

public class AmazonBot extends TimerTask {

    private final String url;
    private final double targetPrice;
    private Document document;

    public AmazonBot(String url, double targetPrice) {
        this.url = url;
        this.targetPrice = targetPrice;
    }

    public void run() {
        connect();
        Element priceBlock = document.getElementById("priceblock_ourprice");
        if (priceBlock == null) {
            System.out.println("Nie można znleźć elementu. Sprawdź czy podany przez Ciebie link jest poprawny.");
            return;
        }
        priceCheck(priceBlock);
    }

    private void connect() {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Coś poszło nie tak.");
            System.out.println(e.getMessage());
        }
    }

    private boolean priceCheck(Element priceBlock) {
        Date now = new Date();
        String textPrice = priceBlock.text().substring(0, priceBlock.text().length() - 3).replaceAll("\\s+", "").replaceAll(",", ".");
        double price = Double.parseDouble(textPrice);
        System.out.println(now + "  |  " + price + "PLN");
        return price < targetPrice;
    }
}
