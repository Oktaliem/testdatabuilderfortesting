package com.oktaliem.unittest;

import com.oktaliem.builder.WebScraperBuilder;
import org.junit.Test;

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
}
