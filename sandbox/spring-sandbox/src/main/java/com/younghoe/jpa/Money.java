package com.younghoe.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * <p>
 *     3rd party 라이브러리 의존 없이 통화와 금액을 저장하고 운반하기 위한 클래스
 * </p>
 *
 * @author Younghoe Ahn
 */
@Embeddable
public class Money {

    @Column
    private String currencySymbol;

    @Column
    private BigDecimal amount;

    public Money(String currencySymbol, BigDecimal amount) {
        this.currencySymbol = currencySymbol;
        this.amount = amount;
    }

    public Money(){}
}
