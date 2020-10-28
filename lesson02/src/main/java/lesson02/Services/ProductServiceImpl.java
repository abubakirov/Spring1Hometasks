package lesson02.Services;

import lesson02.Repositories.ProductRepositoryImpl;
import lesson02.domain.Product;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {
    private ProductRepositoryImpl productRepo;

    public ProductServiceImpl(ProductRepositoryImpl productRepo) {
        this.productRepo = productRepo;
    }

    public Product getById(Long id) {
        return productRepo.getById(id);
    }

    public List<Product> getAll() {
        List<Product> products = productRepo.getAll();
        products.sort(Comparator.comparingLong(Product::getId));
        return products;
    }

    public List<Product> getByPrice(Double start, Double end) {
        return productRepo.getAll().stream()
                .filter(product -> product.getPrice() >= start && product.getPrice() <= end)
                .sorted(Comparator.comparingLong(Product::getId))
                .collect(Collectors.toList());
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public void removeById(Long id) {
        productRepo.remove(id);
    }
}
