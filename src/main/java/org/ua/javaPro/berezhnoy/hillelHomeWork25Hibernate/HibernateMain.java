package org.ua.javaPro.berezhnoy.hillelHomeWork25Hibernate;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class HibernateMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateSession.class);
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        ;
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Hero> query = builder.createQuery(Hero.class);
            Root<Hero> root = query.from(Hero.class);
            query.select(root).where(builder.equal(root.get("name"), "Hulk"));
            Hero heroName = session.createQuery(query).uniqueResult();
            var heroId = session.find(Hero.class, 564);

            System.out.println(heroName);
            System.out.println(heroId);

            var id = session.save(Hero.builder()
                    .name("roror")
                    .gender("male")
                    .eyeColor("red")
                    .race("orc")
                    .hairColor("blue")
                    .height(456.7)
                    .publisher("hz")
                    .skinColor("red")
                    .alignment("good")
                    .weight(40)
                    .build());
            System.out.println(id);

            Hero heroDelete = session.get(Hero.class, 734);
            if (heroDelete != null) {
                session.beginTransaction();
                session.delete(heroDelete);
                session.getTransaction().commit();
            }

        }


    }
}
