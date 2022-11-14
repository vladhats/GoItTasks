package HW13;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

class Scratch {
    public static void main(String[] args) throws IOException {
        String url = "https://rozetka.com.ua/ua/acer-nhqeseu00d/p353550678/?gclid=Cj0KCQiApb2bBhDYARIsAChHC9sO6gnkHL9OQf3I596qD97_DZVoYRATravaqGDqKUPiZdZJky2oNdAaArqJEALw_wcB";
        Document  document = Jsoup.connect(url).get();
        Element element = document.selectFirst("p.product-prices__big");
        System.out.println(element.text());
    }
}