package lesson03_lect;

import lesson03_lect.hibernate.Person;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Program {
    public static void main(String[] args) {
        EntityManagerFactory entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = entityFactory.createEntityManager();
        createEntity(em);
        Person readEntity = readEntity(em, 1L);
        readEntity.setFirstName("Vladimir");

    }

    private static void createEntity(EntityManager em) {
        System.out.println("Creating entity...");
        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Petrov");
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        System.out.println(person.getId());
        System.out.println("Creation finished");
    }

    private static Person readEntity(EntityManager em, long id) {
        System.out.println("Reading entity...");
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.getTransaction().commit();
        System.out.println("Reading completed -> " + person);
        return person;
    }

    private static void saveEntity(EntityManager em, Person entity) {
        System.out.println("Saving entity...");
        em.getTransaction().begin();
        Person savedEntity = em.merge(entity);
        em.getTransaction().commit();
        System.out.println("Entity saved!");
    }
}
