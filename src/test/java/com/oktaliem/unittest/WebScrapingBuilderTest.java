package com.oktaliem.unittest;

import com.oktaliem.builder.WebScraperBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import static com.oktaliem.constants.ConstantsWithJavaInterface.HTML_FILE;

public class WebScrapingBuilderTest {
    public static final String url = "https://www.randomlists.com/";
    WebScraperBuilder scrappers = new WebScraperBuilder(url);

    @Test
    public void getTitleAndBody() {
        scrappers.getTitleAndBody();
    }

    @Test
    public void getHrefLink() {
        scrappers.getHrefLink();
    }

    @Test
    public void getLinkText() {
        scrappers.getLinkText();
    }

    @Test
    public void getOuterHtml() {
        scrappers.getOuterHtml();
    }

    @Test
    public void getInnerHtml() {
        scrappers.getInnerHtml();
    }

    @Test
    public void getValueByTag() {
        scrappers.getElByTag();
    }

    @Test
    public void getValueByAttribute(){
        scrappers.getElByAttribute();
    }

    @Test
    public void getAllElementsNodeName(){
        scrappers.getAllElFromHtmlFile();
    }




}
