package cn.lhqs.middle;

import cn.lhqs.middle.utils.TimeTools;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-06 13:33
 * description : OtherTest.class
 * version : 1.0
 */
public class OtherTest {

    @Test
    public void timeToolTest() {
        // String times = "2018-06-04T16:00:00.000Z";
        // LocalDateTime datetime = TimeTools.dataTypeTransform(times, TimeTools.DATE_TYPE1);
        // System.out.println(datetime);
        Date data = new Date();
        System.out.println(data);
        LocalDateTime datetime = TimeTools.dataTypeTransform("2018-06-04T16:00:00.00Z", TimeTools.DATE_TYPE1);
        System.out.println(datetime);
    }

    @Test
    public void java8Test() {
        Instant now = Instant.now();
        System.out.println(now);
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println("-----------------------------------------");
        // String dayAfterTommorrow = "20140116";
        // LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
        //         DateTimeFormatter.BASIC_ISO_DATE);
        // System.out.printf("Date generated from String %s is %s", dayAfterTommorrow, formatted);
        String goodFriday = "Apr 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }
    }
}
