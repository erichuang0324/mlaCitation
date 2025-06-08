import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Scanner;
public class mainMla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try{
            Document doc = Jsoup.connect(input)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36 Edg/137.0.0.0")
                    .referrer("http://www.google.com")
                    .header("Accept-Language", "en-US,en;q=0.9")
                    .timeout(10*1000)
                    .followRedirects(true)
                    .get();
            System.out.println(doc.getElementsByTag("meta"));
            Element authorData = doc.selectFirst("meta[property=cXenseParse:author]");
            System.out.println(authorData.attr("content"));



        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
