package HW13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsoupJsonTest {
    public static void main(String[] args) throws IOException, HttpStatusException {
        String url = "https://api.monobank.ua/bank/currency";
        String response = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        System.out.println(response);
        Type type = TypeToken.getParameterized(List.class, Currenfjsdj.class)
                .getType();
        List<Currenfjsdj> currenfjsdjs = new Gson().fromJson(response, type);
        System.out.println(currenfjsdjs);

    }
}
