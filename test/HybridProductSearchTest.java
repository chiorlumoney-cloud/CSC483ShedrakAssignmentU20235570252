import static org.junit.Assert.*;
import org.junit.Test;

public class HybridProductSearchTest {
    @Test
    public void testSearch() {
        HybridProductSearch search = new HybridProductSearch();
        Product p = new Product(1, "Phone", "Electronics", 500, 10);
        search.addProduct(p);
        assertEquals(p, search.binarySearchById(1));
    }
}
