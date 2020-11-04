package domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lect03_clients")
@NamedQueries({
        @NamedQuery(name = "Client.findAll", query = "SELECT a From Client a")
})
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Purchase> purchases;


    //<editor-fold desc="getters/setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
    //</editor-fold>


    @Override
    public String toString() {
        return "Id=" + id + ", Name=\'" + name + "\', Number of purchases=" + purchases.size();
    }
}
