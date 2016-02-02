package com.younghoe.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *     간단한 JPA 애플리케이션으로 Spring-boot 기반에서 구동
 *     <ul>
 *         <li>Entity 저장할 때 @{link LocalDateTimeAttributeConverter} 적용</li>
 *         <li>Entity 저장할 때 @{link javax.persistence.Embedded Embedded} 적용</li>
 *     </ul>
 * </p>
 *
 * @author Younghoe Ahn
 */
@SpringBootApplication
@RestController
public class JpaApplication {
    public static void main(String... args){
        SpringApplication.run(JpaApplication.class, args);
    }

    @Autowired
    EntityRepository repository;

    @RequestMapping("add/entity")
    public Entity add(){
        Entity entity = new Entity(new Money("KSW", new BigDecimal(5000).setScale(0)), LocalDateTime.now());
        repository.save(entity);
        return entity;
    }
}
