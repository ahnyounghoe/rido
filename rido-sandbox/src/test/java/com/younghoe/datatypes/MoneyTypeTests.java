package com.younghoe.datatypes;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Created by tony on 2016. 1. 26..
 */
public class MoneyTypeTests {

    /**
     * <p><a href="http://blog.eisele.net/2011/08/working-with-money-in-java.html">java.util.Currency</a>에 대한 내용 학습</p>
     * <p>Decimal place에 대한 테스트는 <a hef="https://github.com/JodaOrg/joda-money/blob/master/src/main/java/org/joda/money/BigMoney.java">
     *     Joda-Money</a>에서 구현한 내용을 기반으로 확인</p>
     * <p>원화 표기에 대한 내용은 <a href="https://docs.oracle.com/javase/tutorial/java/data/numberformat.html">Java Tutorial</a>
     * 에서 참조</p>
     *
     * @see https://en.wikipedia.org/wiki/ISO_4217
     */
    @Test
    public void study_currency_and_bigdecimal_for_Record(){
        Currency ksw = Currency.getInstance(Locale.KOREA);
        assertEquals("￦", ksw.getSymbol());
        assertEquals("KRW", ksw.getCurrencyCode());
        assertEquals("대한민국 원", ksw.getDisplayName());
        assertEquals(0, ksw.getDefaultFractionDigits());
        assertEquals(410, ksw.getNumericCode());

        // From Joda-Money's BigMoney class Javadoc
        assertEquals(2, Currency.getInstance(Locale.US).getDefaultFractionDigits());
        assertEquals(2, Currency.getInstance(Locale.UK).getDefaultFractionDigits());
        assertEquals(2, Currency.getInstance(Locale.FRANCE).getDefaultFractionDigits());

        assertEquals(0, Currency.getInstance(Locale.JAPAN).getDefaultFractionDigits());

        // BigDecimal
        System.out.println(1000 / 3);
        System.out.println(1000.00 / 3);
        System.out.println(new BigDecimal(1000).divide(new BigDecimal(3), BigDecimal.ROUND_CEILING));
        System.out.println(new BigDecimal(1000).divide(new BigDecimal(3), BigDecimal.ROUND_HALF_EVEN));
        System.out.println(new BigDecimal(1000).divide(new BigDecimal(3), BigDecimal.ROUND_FLOOR));

        // Simple KRW Money
        KrWon won = new KrWon(30000);
        assertEquals(30000, won.amount());
        assertEquals("30,000", won.withComma());
        System.out.println("Max of Int: " + Integer.MAX_VALUE);
        System.out.println("Max of Long: " + Long.MAX_VALUE);

        // Use Joda-money
        Money money = Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000.0));
        assertEquals(30000, money.getAmountMajorInt());
        assertEquals(new BigDecimal(30000), money.getAmount());
        assertEquals(new BigDecimal(30000), money.getAmountMinor());
        assertEquals(new BigDecimal(30000), money.getAmountMajor());
        assertEquals("￦", money.getCurrencyUnit().getSymbol());
        assertNotSame("₩", money.getCurrencyUnit().getSymbol()); // WARN!
        assertEquals("\uFFE6", money.getCurrencyUnit().getSymbol());
        assertNotSame("\u20A9", money.getCurrencyUnit().getSymbol()); // WARN!

    }
}
