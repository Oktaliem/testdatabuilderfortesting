package com.oktaliem.builder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.testng.Assert.fail;

public class WebScraperBuilder {

    public void getDataWithJsoup(String urlStr) {
        Document doc = null;
        try {
            doc = Jsoup.connect(urlStr)
                    .timeout(10 * 1000)
                    .get();
        } catch (IOException e) {
            System.out.println("Error found --> " + e);
            fail();
        }
        if (doc != null) {
            String title = doc.title();
            System.out.println("Title: " + title);
            String text = doc.body().text();
            System.out.println("Text: " + text);
            Elements links = doc.select("a[href]");

            for (Element link : links) {
                System.out.println("=============================================================================");
                String linkHref = link.attr("href");
                System.out.println("linkHref: " + linkHref);
                String linkText = link.text();
                System.out.println("linkText: " + linkText);
                String linkOuterHtml = link.outerHtml();
                System.out.println("linkOuterHtml: " + linkOuterHtml);
                String linkInnerHtml = link.html();
                System.out.println("linkInnerHtml: " + linkInnerHtml);
            }
            System.out.println("Links by index: " + links.get(11));
            System.out.println("Links by Text Random: " + links.get(11).getElementsMatchingOwnText("Random"));
            System.out.println("Links size: " + links.size());
            System.out.println("Links by Tag: " + doc.getElementsByTag("span"));
            System.out.println("Link Name by Tag: " + doc.getElementsByTag("span").get(11));
        }

    }
}
