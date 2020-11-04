package domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lect03_products")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT a FROM Product a")
})
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
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


    @Override
    public String toString() {
        return "Id=" + id + ", title=\'" + title + "\', Number of sales=" + sales.size();
    }
}
