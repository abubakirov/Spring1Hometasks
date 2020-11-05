package service;

import domain.Client;
import domain.Product;
import domain.Purchase;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private EntityManager em;
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {
            // Main menu
            System.out.println("Choose action:");
            System.out.println("1\tClients");
            System.out.println("2\tProducts");
            System.out.println("0\tExit");

            int chosen = chosenVariant();

            switch (chosen) {
                case 1:
                    clients();
                    break;
                case 2:
                    products();
                    break;
                case 0:
                    return;
                default:
                    wrongVariant();
            }
            System.out.println("\n\n\n");
        }
    }

    //<editor-fold desc="clients">
    private void clients() {
        // Main -> Clients
        System.out.println("1\tList of clients");
        System.out.println("2\tView client's details");
        System.out.println("3\tAdd client");
        System.out.println("0\tBack to main menu");

        int chosen = chosenVariant();
        switch (chosen) {
            case 1:
                clientsList();
                break;
            case 2:
                clientDetails();
                break;
            case 3:
                addClient();
                break;
            case 0:
                System.out.println("Returning back to main menu");
                return;
            default:
                wrongVariant();
                return;
        }
    }

    private void clientsList() {
        List<Client> clients = em.createNamedQuery("Client.findAll", Client.class).getResultList();
        for (Client client: clients) {
            System.out.println(client.toString());
        }
    }

    private void clientDetails() {
        //TODO

    }

    private void addClient() {
        System.out.print("Enter the name of the new customer:\t");
        String name = scanner.nextLine();
        Client client = new Client();
        client.setName(name);
        client.setPurchases(new ArrayList<Purchase>());
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        System.out.print("Customer added:\t");
        System.out.println(client);
    }

    //</editor-fold>

    //<editor-fold desc="products">

    private void products() {
        System.out.println("1\tList of products");
        System.out.println("2\tView product's details");
        System.out.println("3\tAdd product");
        System.out.println("0\tBack to main menu");

        int chosen = chosenVariant();
        switch (chosen) {
            case 1:
                productsList();
                break;
            case 2:

                break;
            case 3:

                break;
            case 0:
                System.out.println("Returning back to main menu");
                break;
            default:
                wrongVariant();
                break;
        }
        System.out.println("\n\n\n");
    }

    private void productsList() {
        List<Product> products = em.createNamedQuery("Product.findAll", Product.class).getResultList();
        for (Product product: products) {
            System.out.println(product.toString());
        }
        System.out.println("\n\n\n");
    }

    private void productDetails()
    {
        System.out.println("Enter id");
        System.out.println("Enter \'0\' to go back to the main menu");
        System.out.println("Enter empty string to view the list of product and then choose one of them");
        String line = scanner.nextLine();

        if (line == "") {
            List<Product> products = em.createNamedQuery("Product.findAll", Product.class).getResultList();
            for (Product product: products) {
                System.out.println(product.toString());
            }
            System.out.println("Choose id");
            line = scanner.nextLine();
        }

        long chosen = 0L;
        try {
            chosen = Long.valueOf(line);
            if (chosen == 0) {
                System.out.println("Returning back to the main menu\n\n\n");
                return;
            }
        } catch (NumberFormatException e) {
            wrongVariant();
            return;
        }

        Product product = em.find(Product.class, chosen);
        System.out.println(product);
        System.out.println("Choose action:");
        System.out.println("1\tChange title");
        System.out.println("2\tShow sales");
        System.out.println("3\tRemove sale");

    }

    //</editor-fold>

    private void wrongVariant() {
        System.out.println("Wrong variant chosen");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private int chosenVariant() {
        String line = scanner.nextLine();
        int result;
        try {
            result = Integer.valueOf(line);
        } catch (NumberFormatException e) {
            result = -1;
        }
        return result;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }



}
