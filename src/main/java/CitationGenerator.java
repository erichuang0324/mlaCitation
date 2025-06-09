import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.URL;

public class CitationGenerator {
    public static String generateMlaCitation(String url) throws Exception {
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36")
                .referrer("http://www.google.com")
                .header("Accept-Language", "en-US,en;q=0.9")
                .timeout(10 * 1000)
                .followRedirects(true)
                .get();

        String author = null;
        String[] authorSelectors = {
                "meta[name=author]",
                "meta[property*=author]",
                "meta[name*=author]"
        };
        for (String selector : authorSelectors) {
            Element element = doc.selectFirst(selector);
            if (element != null) {
                String content = element.attr("content");
                if (!content.isEmpty()) {
                    author = content;
                    break;
                }
            }
        }

        String title = null;
        Element titleMeta = doc.selectFirst("meta[property=og:title]");
        if (titleMeta != null && !titleMeta.attr("content").isEmpty()) {
            title = titleMeta.attr("content");
        } else {
            title = doc.title();
        }

        String website = null;
        Element siteMeta = doc.selectFirst("meta[property=og:site_name]");
        if (siteMeta != null && !siteMeta.attr("content").isEmpty()) {
            website = siteMeta.attr("content");
        } else {
            website = new URL(url).getHost();
        }

        String date = null;
        String[] dateSelectors = {
                "meta[property*=published]",
                "meta[name*=pubdate]",
                "meta[name*=date]"
        };
        for (String selector : dateSelectors) {
            Element element = doc.selectFirst(selector);
            if (element != null) {
                String content = element.attr("content");
                if (!content.isEmpty()) {
                    date = content;
                    break;
                }
            }
        }

        StringBuilder citation = new StringBuilder();
        if (author != null) {
            citation.append(author).append(". ");
        }
        citation.append("\"").append(title).append(".\" ");
        citation.append(website);
        if (date != null) {
            citation.append(", ").append(date);
        }
        citation.append(", ").append(url);
        return citation.toString();
    }
}
