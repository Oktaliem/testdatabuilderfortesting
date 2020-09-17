package com.oktaliem.unittest;

import com.oktaliem.builder.WebScraperBuilder;
import org.junit.Test;

public class WebScrappingBuilderTest {

    @Test
    public void webScrappingWithJsoupBuilder(){
        WebScraperBuilder scrappers = new WebScraperBuilder();
        scrappers.getDataWithJsoup("https://www.randomlists.com/");
    }
}
