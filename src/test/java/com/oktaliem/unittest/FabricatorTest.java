package com.oktaliem.unittest;

import fabricator.*;
import fabricator.entities.CsvFileBuilder;
import fabricator.enums.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FabricatorTest {

    @Test
    public void alfaNumericTestData() {
        Alphanumeric numeric = Fabricator.alphaNumeric();
        System.out.println("Get test Data 1: " + numeric.numerify("###ABC"));
        System.out.println("Get test Data 2: " + numeric.letterify("???123"));
        System.out.println("Get test Data 3: " + numeric.botify("???###"));
        System.out.println("Get test Data 4: " + numeric.randomInt());
        System.out.println("Get test Data 5: " + numeric.randomString(20));
        System.out.println("Get test Data 6: " + numeric.randomLong(-1, 50));
        System.out.println("Get test Data 7: " + numeric.randomBoolean());
        System.out.println("Get test Data 8: " + numeric.randomDouble(2.52, 4.55));
        System.out.println("Get test Data 9: " + numeric.productPrefix());
        System.out.println("Get test Data 10: " + numeric.randomGuid());
        System.out.println("Get test Data 11: " + numeric.randomGuid(2));
        System.out.println("Get test Data 12: " + numeric.randomHash());
        System.out.println("Get test Data 13: " + numeric.randomHash(34));
        System.out.println("Get test Data 14: " + numeric.randomStringsAsJavaList(2, 8, 5));
        System.out.println("Get test Data 15: " + numeric.randomString("ASKING", 6));
        System.out.println("Get test Data 16: " + numeric.randomStringsAsJavaList());
        System.out.println("Get test Data 17: " + numeric.randomFloat());
        System.out.println("Get test Data 18: " + numeric.randomHashAsJavaList());
        System.out.println("Get test Data 19: " + numeric.randomGuidAsJavaList());
        System.out.println("Get test Data 20: " + numeric.random$1());
    }

    @Test
    public void calendarTestData() {
        Calendar calendar = Fabricator.calendar();
        System.out.println("Get test Data 1: " + calendar.minute());
        System.out.println("Get test Data 2: " + calendar.year());
        System.out.println("Get test Data 3: " + calendar.day());
        System.out.println("Get test Data 4: " + calendar.second());
        System.out.println("Get test Data 5: " + calendar.month());
        System.out.println("Get test Data 6: " + calendar.time24h());
        System.out.println("Get test Data 7: " + calendar.time12h());
        System.out.println("Get test Data 8: " + calendar.ampm());
        System.out.println("Get test Data 9: " + calendar.century());
        System.out.println("Get test Data 10: " + calendar.dayOfWeek());
        System.out.println("Get test Data 11: " + calendar.hour12h());
        System.out.println("Get test Data 12: " + calendar.hour24h());
        System.out.println("Get test Data 13: " + calendar.month(false));
        System.out.println("Get test Data 14: " + calendar.month(true));
        System.out.println("Get test Data 15: " + calendar.datesRange().getRandomDate());
        System.out.println("Get test Data 16: " + calendar.randomDate().asDate());
        System.out.println("Get test Data 17: " + calendar.relativeDate(DateTime.now().plusDays(1)).tomorrow().asString());
        System.out.println("Get test Data 18: " + calendar.relativeDate(DateTimeZone.UTC).tomorrow().asString(DateFormat.dd_MM_yyyy));
        System.out.println("Get test Data 19: " + calendar.datesRange().asStringsJavaList());
        System.out.println("Get test Data 20: " + calendar.datesRange()
                .startYear(1990)
                .startMonth(1)
                .startDay(1)
                .stepEvery(1, DateRangeType.DAYS)
                .endYear(2011)
                .endMonth(1)
                .endDay(1).asList());
    }

    @Test
    public void contactTestData() {
        Contact contact = Fabricator.contact();
        System.out.println("Get test Data 1: " + contact.firstName());
        System.out.println("Get test Data 2: " + contact.birthday(20));
        System.out.println("Get test Data 3: " + contact.occupation());
        System.out.println("Get test Data 4: " + contact.height(true));
        System.out.println("Get test Data 5: " + contact.weight(false));
        System.out.println("Get test Data 6: " + contact.bsn());
        System.out.println("Get test Data 7: " + contact.eMail());
        System.out.println("Get test Data 8: " + contact.phoneNumber());
        System.out.println("Get test Data 9: " + contact.bloodType());
        System.out.println("Get test Data 10: " + contact.religion());
        System.out.println("Get test Data 11: " + contact.address());
        System.out.println("Get test Data 12: " + contact.zodiac());
        System.out.println("Get test Data 13: " + contact.country());
    }

    @Test
    public void fileTestData() {
        FileGenerator file = Fabricator.file();
        System.out.println("Get test Data 1: " + file.image(200, 200, "target/test.png"));
        System.out.println("Get test Data 2: " + file.fileExtension(FileType.AUDIO));
        System.out.println("Get test Data 3: " + file.fileExtension());
        System.out.println("Get test Data 4: " + file.fileExtension(FileType.DOCUMENT));
        System.out.println("Get test Data 5: " + file.fileExtension(FileType.VIDEO));
        System.out.println("Get test Data 6: " + file.mime_type(MimeType.APPLICATION));
    }

    @Test
    public void generateCsvTestData() {
        CsvValueCode[] codes = {
                CsvValueCode.FIRST_NAME,
                CsvValueCode.LAST_NAME,
                CsvValueCode.BIRTHDAY,
                CsvValueCode.EMAIL,
                CsvValueCode.PHONE,
                CsvValueCode.ADDRESS,
                CsvValueCode.BSN,
                CsvValueCode.WEIGHT,
                CsvValueCode.HEIGHT,
                CsvValueCode.VISA
        };
        CsvFileBuilder csv = Fabricator.file().csvBuilder();
        csv.withCodes(codes).withNumberOfRows(20).build();
        //find csv output file on ${workspace}/generateFiles/result.csv
    }

    @Test
    public void generateFinanceTestData(){
        Finance finance = Fabricator.finance();
        System.out.println("Get test Data 1: " + finance.bic());
        System.out.println("Get test Data 2: " + finance.pinCode());
        System.out.println("Get test Data 3: " + finance.visaCard());
        System.out.println("Get test Data 4: " + finance.iban());
        System.out.println("Get test Data 5: " + finance.americanExpressCard());
        System.out.println("Get test Data 6: " + finance.bsn());
        System.out.println("Get test Data 7: " + finance.dinersCard());
        System.out.println("Get test Data 8: " + finance.discoverCard());
        System.out.println("Get test Data 9: " + finance.jcbCard());
        System.out.println("Get test Data 10: " + finance.masterCard());
        System.out.println("Get test Data 11: " + finance.ssn());
        System.out.println("Get test Data 12: " + finance.voyagerCard());
        System.out.println("Get test Data 13: " + finance.visaCard(16));
        System.out.println("Get test Data 14: " + Arrays.toString(finance.masterCards(5)));
    }


}
