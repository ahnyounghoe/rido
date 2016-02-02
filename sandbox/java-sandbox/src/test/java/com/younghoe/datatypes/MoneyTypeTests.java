package com.younghoe.datatypes;

import junit.framework.TestCase;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Created by tony on 2016. 1. 26..
 */
public class MoneyTypeTests {

    /**
     * <p>
     *     통화 데이터 사용에 대한 학습
     *     <ul>
     *         <li>@{link java.util.Currency Currency}</li> 클래스로 대한민국 원 표시</li>
     *         <li>@{link java.math.BigDecimal BigDecimal} 간단히 써보기</li>
     *         <li>외부 라이브러리 없이 간단하게 통화 데이터를 표현하는 방법</li>
     *     </ul>
     * </p>
     *
     * @see <a href="http://blog.eisele.net/2011/08/working-with-money-in-java.html">java.util.Currency</a>
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/data/numberformat.html">Java Tutorial</a>
     * @see <a href="https://en.wikipedia.org/wiki/ISO_4217">ISO 4217</a>
     */
    @Test
    public void study_currency_and_bigdecimal_for_Record() {
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

    }

    /**
     * <p>
     *     @{link org.joda.money.Money} 사용법 확인
     * </p>
     *
     * @see <a href="http://www.joda.org/joda-money/">Joda-Money User Guide</a>
     * @see <a hef="https://github.com/JodaOrg/joda-money/blob/master/src/main/java/org/joda/money/BigMoney.java">Joda-Money</a>
     */
    @Test
    public void using_joda_money(){
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

        // create a monetary value
        money = Money.parse("USD 23.87");
        System.out.println(money);

        // Same as USd
        System.out.println(Money.parse("KRW 2000.0"));

        // add another amount with safe double conversion
        CurrencyUnit usd = CurrencyUnit.of("USD");
        System.out.println(usd);

        CurrencyUnit krw = CurrencyUnit.of("KRW");
        TestCase.assertEquals("￦", krw.getSymbol());
        TestCase.assertEquals("KRW", krw.getCurrencyCode());
        TestCase.assertEquals("KRW", krw.getCode());
        TestCase.assertEquals(0, krw.getDecimalPlaces());
        TestCase.assertEquals(CurrencyUnit.class, krw.getClass());
        TestCase.assertEquals(false, krw.isPseudoCurrency());
        TestCase.assertEquals("410", krw.getNumeric3Code());
        TestCase.assertEquals(410, krw.getNumericCode());
        TestCase.assertEquals(Currency.getInstance(Locale.KOREA), krw.toCurrency());

        for(String countryCode : krw.getCountryCodes())
            System.out.println("countryCode: " + countryCode);

        for(String countryCode : CurrencyUnit.of("JPY").getCountryCodes())
            System.out.println("countryCode: " + countryCode);

    }

}   class KrWon{
    private int amount;

    KrWon(int amount){
        this.amount = amount;
    }

    public int amount() {
        return this.amount;
    }

    public String withComma() {
        return new DecimalFormat("#,###,###,###").format(this.amount);
    }
}