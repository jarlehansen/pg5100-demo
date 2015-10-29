package no.nith.pg5100;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;

@Model
public class ScopesController {
    private int value = 0;

    @PostConstruct
    public void init() {
        System.out.println("ScopesController.init");
    }

    @PreDestroy
    public void close() {
        System.out.println("ScopesController.close");
    }

    public int incrementAndGetValue() {
        value++;
        return value;
    }

}
