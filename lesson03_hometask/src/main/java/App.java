import org.hibernate.cfg.Configuration;
import service.Menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager em = entityFactory.createEntityManager();

        Menu menu = new Menu();
        menu.setEm(em);

        menu.start();
    }
}
