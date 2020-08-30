package com.oktaliem.unittest;

import com.oktaliem.constants.ConstantsWithJavaEnumForSwitch;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static com.oktaliem.constants.ConstantsWithJavaClass.FOURTH_BOOK;
import static com.oktaliem.constants.ConstantsWithJavaClass.THIRD_BOOK;
import static com.oktaliem.constants.ConstantsWithJavaEnum.*;
import static com.oktaliem.constants.ConstantsWithJavaEnumForSwitch.*;
import static com.oktaliem.constants.ConstantsWithJavaInterface.FIRST_BOOK;
import static com.oktaliem.constants.ConstantsWithJavaInterface.SECOND_BOOK;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConstantTest {

    @Test
    public void constantWithJavaInterfaceTest() {
        Assert.assertEquals("Harry Potter", FIRST_BOOK);
        Assert.assertEquals("One-Punch Man", SECOND_BOOK);
    }

    @Test
    public void constantWithJavaClassTest() {
        Assert.assertEquals("Harry Potter", THIRD_BOOK);
        Assert.assertEquals("One-Punch Man", FOURTH_BOOK);
    }


    @Test
    public void constantWithJavaEnumTest() {
        ConstantsWithJavaEnumForSwitch[] countries = {JAPAN, UK, USA};
        for (ConstantsWithJavaEnumForSwitch country : countries) {
            switch (country) {
                case JAPAN:
                    Assert.assertEquals("Japan",ANIME.country );
                    Assert.assertEquals("One-Punch Man", ANIME.bookNames.get(0) );
                    Assert.assertEquals(ANIME.totalBooks, 3);
                    break;
                case UK:
                    Assert.assertEquals( "UK",NOVEL.country);
                    Assert.assertEquals( "Loving",NOVEL.bookNames.get(2));
                    Assert.assertEquals( 3,NOVEL.totalBooks);
                    break;
                case USA:
                    Assert.assertEquals("USA", COMIC.country );
                    Assert.assertEquals("Iron Man", COMIC.bookNames.get(1) );
                    Assert.assertEquals(3, COMIC.totalBooks );
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + country);
            }
        }

        List<String> animeBooksList = Arrays.asList("One-Punch Man", "Doraemon", "Dragon Ball Z");
        List<String> comicBooksList = Arrays.asList("Captain America", "Iron Man", "Hulk");
        List<String> novelBooksList = Arrays.asList("Harry Potter", "Orlando", "Loving");
        Assert.assertEquals(animeBooksList,ANIME.getBookNames());
        Assert.assertEquals(comicBooksList,COMIC.getBookNames());
        Assert.assertEquals(novelBooksList,NOVEL.getBookNames());
    }
}
