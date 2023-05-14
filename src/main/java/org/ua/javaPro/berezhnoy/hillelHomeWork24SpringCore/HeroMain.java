package org.ua.javaPro.berezhnoy.hillelHomeWork24SpringCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroService;

public class HeroMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HeroConfiguration.class);
        HeroService heroService = context.getBean(HeroService.class);
        System.out.println(heroService.findByName("A-Bomb"));
    }
}
