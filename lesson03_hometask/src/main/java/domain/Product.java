package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany
    private List<Purchase> sales;

    //<editor-fold desc="getters/setters">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Purchase> getSales() {
        return sales;
    }

    public void setSales(List<Purchase> sales) {
        this.sales = sales;
    }

    //</editor-fold>
}
