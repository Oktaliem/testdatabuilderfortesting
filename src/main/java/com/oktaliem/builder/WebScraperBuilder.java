package com.oktaliem.builder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.testng.Assert.fail;

public class WebScraperBuilder {
    private final Document page;
    private Elements links;

    public WebScraperBuilder(String url) {
        page = setUpJsoupConnection(url);
        links = page.select("a[href]");
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

    public void getTitleAndBody() {
        String title = page.title();
        System.out.println("Title: " + title);

        String text = page.body().text();
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

    public void getElByTag() {
        links = page.getElementsByTag("Span");
        for (Element link : links) {
            //Raw
            System.out.println(link);
        }

        System.out.println("=============================");

        for (Element link : links) {
            // get text only
            System.out.println(link.text());
        }

        System.out.println("=============================");

        //Filter, remove "Search" and "Male Names"
        for (Element link : links) {
            if (!link.text().equals("Search") && !link.text().equals("Male Names")) {
                System.out.println(link.text());
            }
        }
    }

    public void getElByAttribute() {
        links = page.getElementsByAttribute("content");
        for (Element link : links) {
            System.out.println(link.attr("content"));
        }

        System.out.println("=============================");

        links = page.getElementsByTag("link");
        for (Element link : links) {
            System.out.println(link);
            System.out.println(link.attr("sizes"));
        }
    }
}
