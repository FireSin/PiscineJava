package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ProductsRepositoryJdbcImplTest {

    private ProductsRepository _productsRepository;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(new Product(1l, "Cup", 150),
            new Product(2l, "Fork", 100),
            new Product(3l, "Spoon", 110),
            new Product(4l, "Capture", 1500),
            new Product(5l, "Clock", 1000));
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(4l, "Capture", 1500);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(5l, "Clock", 1200);
    final Product EXPECTED_SAVE_PRODUCT = new Product(6l, "Table", 6200);

    @BeforeEach
    void SetUp(){
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).addScript("schema.sql").addScript("data.sql").build();
        _productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void findAll() {
        assertEquals(EXPECTED_FIND_ALL_PRODUCTS, _productsRepository.findAll());
    }

    @Test
    void findByIdTest() {
        assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, _productsRepository.findById(4l).get());
        assertNotEquals(EXPECTED_FIND_BY_ID_PRODUCT, _productsRepository.findById(1l).get());
    }

    @Test
    void updateTest() {
        _productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        assertEquals(EXPECTED_UPDATED_PRODUCT, _productsRepository.findById(5l).get());
    }

    @Test
    void saveTest() {
        _productsRepository.save(new Product(null, "Table", 6200));
        assertEquals(Optional.of(EXPECTED_SAVE_PRODUCT), _productsRepository.findById(6l));
    }

    @Test
    void deleteTest() {
        _productsRepository.delete(6l);
        assertEquals(Optional.empty(), _productsRepository.findById(6l));
    }
}