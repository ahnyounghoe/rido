package com.younghoe.html;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 *      Serving Static Web Content with Spring Boot. CORS 처리 추가.
 * </p>
 *
 * @author Younghoe Ahn
 * @see <a href="https://spring.io/blog/2013/12/19/serving-static-web-content-with-spring-boot">
 *     Serving Static Web Content with Spring Boot</a>
 * @see <a href="https://spring.io/guides/gs/rest-service-cors/">Enabling Cross Origin Requests for a RESTful Web Service</a>
 */
@SpringBootApplication
@Controller
public class Application {
    public static void main(String... args){
        SpringApplication.run(Application.class, args);
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping("/greeting")
    public @ResponseBody
    Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    class Greeting {

        private final long id;
        private final String content;

        public Greeting(long id, String content) {
            this.id = id;
            this.content = content;
        }

        public long getId() {
            return id;
        }

        public String getContent() {
            return content;
        }
    }
}