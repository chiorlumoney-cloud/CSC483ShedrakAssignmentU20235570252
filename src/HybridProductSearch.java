import java.util.*;

public class HybridProductSearch {
    private List<Product> products;
    private Map<String, Product> nameIndex;

    public HybridProductSearch() {
        products = new ArrayList<>();
        nameIndex = new HashMap<>();
    }

    public void addProduct(Product newProduct) {
        int index = Collections.binarySearch(products, newProduct,
                Comparator.comparingInt(Product::getProductId));
        if (index < 0) index = -(index + 1);
        products.add(index, newProduct);
        nameIndex.put(newProduct.getProductName().toLowerCase(), newProduct);
    }

    public Product binarySearchById(int targetId) {
        int left = 0, right = products.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products.get(mid).getProductId();
            if (midId == targetId) return products.get(mid);
            else if (midId < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public Product searchByName(String targetName) {
        return nameIndex.get(targetName.toLowerCase());
    }
}
