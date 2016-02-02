package com.younghoe.datatypes;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

/**
 * <p>
 *     @{link java.lang.String String}을 enum으로 바꾸기
 * </p>
 */
public class StringToEnumTests {

    @Test
    public void string_to_enum(){
        assertEquals(RevenueOrExpense.수입, RevenueOrExpense.valueOf("수입"));
        assertEquals(RevenueOrExpense.지출, RevenueOrExpense.valueOf("지출"));
        try{
            RevenueOrExpense.valueOf("없는 것..");
            fail();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    enum RevenueOrExpense{
        수입, 지출
    }
}
