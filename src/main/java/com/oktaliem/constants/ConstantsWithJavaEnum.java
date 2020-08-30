package com.oktaliem.constants;

import java.util.Arrays;
import java.util.List;

public enum ConstantsWithJavaEnum {

    ANIME("Japan", Arrays.asList("One-Punch Man", "Doraemon", "Dragon Ball Z"), 3),
    COMIC("USA", Arrays.asList("Captain America", "Iron Man", "Hulk"), 3),
    NOVEL("UK", Arrays.asList("Harry Potter", "Orlando", "Loving"), 3);


    public final String country;
    public final List<String> bookNames;
    public int totalBooks;

    ConstantsWithJavaEnum(String country, List<String> bookNames, int totalBooks) {
        this.country = country;
        this.bookNames = bookNames;
        this.totalBooks = totalBooks;
    }

    public List<String> getBookNames(){
        return this.bookNames;
    }
}
