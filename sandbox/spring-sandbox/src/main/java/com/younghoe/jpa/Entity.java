package com.younghoe.jpa;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * <p>
 *      Generic Entity
 * </p>
 *
 * @author Younghoe Ahn
 */
@javax.persistence.Entity
public class Entity {

    @Id @GeneratedValue
    private long id;

    @Column
    LocalDateTime date;

    @Embedded
    private Money money;

    public Entity(Money money, LocalDateTime date) {
        this.money = money;
        this.date = date;
    }

    public Entity(){}
}
