package com.oktaliem.builder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.testng.Assert.fail;

public class WebScraperBuilder {
    private final Document doc;
    private final Elements links;

    public WebScraperBuilder(String url) {
        doc = setUpJsoupConnection(url);
        links = doc.select("a[href]");
    }

    public void getTitleAndBody() {
        String title = doc.title();
        System.out.println("Title: " + title);
        String text = doc.body().text();
        System.out.println("Text: " + text);
    }

    public void getHrefLink() {
        for (Element link : links) {
            String linkHref = link.attr("href");
            System.out.println("linkHref: " + linkHref);
        }
    }

    public void getLinkText() {
        for (Element link : links) {
            String linkText = link.text();
            System.out.println("linkText: " + linkText);
        }
    }

    public void getOuterHtml() {
        for (Element link : links) {
            String linkOuterHtml = link.outerHtml();
            System.out.println("linkOuterHtml: " + linkOuterHtml);
        }
    }

    public void getInnerHtml() {
        for (Element link : links) {
            String linkInnerHtml = link.html();
            System.out.println("linkInnerHtml: " + linkInnerHtml);
        }
    }

    private Document setUpJsoupConnection(String urlString) {
        Document doc = null;
        try {
            doc = Jsoup.connect(urlString).timeout(10 * 1000).get();
        } catch (IOException e) {
            System.out.println("Error found --> " + e);
            fail();
        }
        return doc;
    }
}
