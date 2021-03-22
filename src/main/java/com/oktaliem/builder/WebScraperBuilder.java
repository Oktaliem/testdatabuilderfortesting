package com.oktaliem.builder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.oktaliem.constants.ConstantsWithJavaInterface.HTML_FILE;
import static org.junit.Assert.fail;

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
            System.out.println(link);//Raw
        }
        System.out.println("=============================");
        for (Element link : links) {
            System.out.println(link.text());// get text only
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
            System.out.println(link);//raw
        }
        System.out.println("=============================");
        for (Element link : links) {
            System.out.println(link.attr("sizes"));//Filtered
        }

    }


    public void getAllElFromHtmlFile() {
        Document document = Jsoup.parse(HTML_FILE);
        Elements allElements = document.getAllElements();

        System.out.println(allElements.get(3).nodeName() + " " + allElements.get(3).ownText());
        System.out.println(allElements.get(2).nodeName() + " " + allElements.get(2).text());
        System.out.println("==========================================");

//        List<String> nodes = new ArrayList<>();
//        for (Element allElement : allElements) {
//            nodes.add(allElement.nodeName());
//        }

        //The same purpose as above
        List<String> nodes = allElements.stream().map(Element::nodeName).collect(Collectors.toList());

        System.out.println("Before Remove Duplicate: " + nodes);
        System.out.println("==========================================");
        List<String> removeDuplicates = new ArrayList<>(new HashSet<>(nodes));
        System.out.println("After Remove Duplicate: " + removeDuplicates);
        for (String element : removeDuplicates) {
            System.out.println(element);
        }
        System.out.println("==========================================");
    }
}
