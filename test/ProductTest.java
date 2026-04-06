import static org.junit.Assert.*;
import org.junit.Test;

public class ProductTest {
    @Test
    public void testProductCreation() {
        Product p = new Product(1, "Laptop", "Electronics", 1000.0, 5);
        assertEquals(1, p.getProductId());
    }
}
