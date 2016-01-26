package com.younghoe.datatypes.jodamoney;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by tony on 2016. 1. 26..
 */
public class JodaMoneyTests {

    /**
     * <p><a href="http://www.joda.org/joda-money/">Joda-Money User Guide</a>를 보고 한글을 추가해달라 요청하기 전에 테스트</p>
     */
    @Test
    public void user_guide(){
        // create a monetary value
        Money money = Money.parse("USD 23.87");
        System.out.println(money);

        // Same as USd
        System.out.println(Money.parse("KRW 2000.0"));

        // add another amount with safe double conversion
        CurrencyUnit usd = CurrencyUnit.of("USD");
        System.out.println(usd);

        CurrencyUnit krw = CurrencyUnit.of("KRW");
        assertEquals("￦", krw.getSymbol());
        assertEquals("KRW", krw.getCurrencyCode());
        assertEquals("KRW", krw.getCode());
        assertEquals(0, krw.getDecimalPlaces());
        assertEquals(CurrencyUnit.class, krw.getClass());
        assertEquals(false, krw.isPseudoCurrency());
        assertEquals("410", krw.getNumeric3Code());
        assertEquals(410, krw.getNumericCode());
        assertEquals(Currency.getInstance(Locale.KOREA), krw.toCurrency());

        for(String countryCode : krw.getCountryCodes())
            System.out.println("countryCode: " + countryCode);

        for(String countryCode : CurrencyUnit.of("JPY").getCountryCodes())
            System.out.println("countryCode: " + countryCode);

    }
}
