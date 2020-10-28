package lesson02.Repositories;

import lesson02.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl {
    private Map<Long, Product> repo = new HashMap<>();
    private Long ind = 0l;

    {
        repo.put(++ind, new Product(ind, "Cheese", 635.0));
        repo.put(++ind, new Product(ind, "Milk", 66.0));
        repo.put(++ind, new Product(ind, "Chocolate", 95.0));
        repo.put(++ind, new Product(ind, "Bread", 39.0));
        repo.put(++ind, new Product(ind, "Beer", 100.0));
    }

    public Product getById(Long id) {
        return repo.get(id);
    }

    public List<Product> getAll() {
        return new ArrayList<>(repo.values());
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(++ind);
        }
        repo.put(product.getId(), product);
        return product;
    }

    public void remove(Long id) {
        repo.remove(id);
    }
}
