
package com.younghoe.datatypes;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

/**
 * Created by tony on 2016. 1. 25..
 */
public class DateTypeTests {

    /**
     * <p>
     * <a href="http://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html">Java SE 8 Date and Time</a> 문서에
     * 기초해서 Java 8 기능을 사용하여 필요한 기능에 국한하여 API를 학습*
     * </p>
     * <p>
     *     출력 형식 제어는 <a href="https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html">Java API</a>
     *     를 보고 학습
     * </p>
     */
    @Test
    public void study_date_for_Record(){
        // 날짜 입력 방법
        // 1.1 현재 시각 입력
        System.out.println(LocalDateTime.now());

        // 1.2 날짜만 지정한 경우
        int year = 2016;
        Month month = Month.JANUARY;
        int day = 25;
        // atStartOfDay로 자정으로 지정하거나 atTime 으로 시간을 지정해줄 수 있음
        LocalDateTime specificDay = LocalDate.of(year, month, day).atStartOfDay();

        System.out.println(specificDay);
        assertEquals(2016, specificDay.getYear());
        assertEquals(Month.JANUARY, specificDay.getMonth());
        assertEquals(25, specificDay.getDayOfMonth());
        assertEquals(0, specificDay.getHour());
        assertEquals(0, specificDay.getMinute());

        // 1.3 시간과 분까지 지정한 경우
        int hour = 10;
        int min = 0;
        specificDay = LocalDate.of(year, month, day).atTime(hour, min);
        System.out.println(specificDay);
        assertEquals(10, specificDay.getHour());
        assertEquals(0, specificDay.getMinute());

        // 출력(formatter)
        // 2. 2015.08.29 형식
        specificDay = LocalDate.of(2015, Month.AUGUST, 29).atTime(10, 00);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        System.out.println(specificDay.format(formatter));

        // 주의 사항
        assertEquals("2015", specificDay.format(DateTimeFormatter.ofPattern("YYYY.MM.dd")).substring(0, 4));
        assertEquals("2015", specificDay.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")).substring(0, 4));
        assertEquals("15", specificDay.format(DateTimeFormatter.ofPattern("yy.MM.dd")).substring(0, 2));

        // WARN: M - month-of-year, m - minute-of-hour
        assertEquals("08", specificDay.format(DateTimeFormatter.ofPattern("YYYY.MM.dd")).substring(5, 7));
        assertEquals("00", specificDay.format(DateTimeFormatter.ofPattern("YYYY.mm.dd")).substring(5, 7));

        // WARN: d - day-of-month, D - day-of-year
        assertEquals("29", specificDay.format(DateTimeFormatter.ofPattern("YYYY.mm.dd")).substring(8, 10));
        assertEquals("241", specificDay.format(DateTimeFormatter.ofPattern("YYYY.mm.DDD")).substring(8, 11));

    }

}