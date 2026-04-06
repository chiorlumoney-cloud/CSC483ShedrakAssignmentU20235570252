import java.util.*;

public class TestSearch {
    public static void main(String[] args) {
        int n = 100000;
        Product[] products = new Product[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int id = rand.nextInt(200000) + 1;
            products[i] = new Product(id, "Product" + id, "Category" + (i % 10),
                                      rand.nextDouble() * 1000, rand.nextInt(500));
        }

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        int bestCaseId = products[0].getProductId();
        int averageCaseId = products[n/2].getProductId();
        int worstCaseId = products[n-1].getProductId();

        long start, seqBest, seqAvg, seqWorst, binBest, binAvg, binWorst;

        start = System.nanoTime();
        SequentialBinarySearch.sequentialSearchById(products, bestCaseId);
        seqBest = System.nanoTime() - start;

        start = System.nanoTime();
        SequentialBinarySearch.sequentialSearchById(products, averageCaseId);
        seqAvg = System.nanoTime() - start;

        start = System.nanoTime();
        SequentialBinarySearch.sequentialSearchById(products, worstCaseId);
        seqWorst = System.nanoTime() - start;

        start = System.nanoTime();
        SequentialBinarySearch.binarySearchById(products, bestCaseId);
        binBest = System.nanoTime() - start;

        start = System.nanoTime();
        SequentialBinarySearch.binarySearchById(products, averageCaseId);
        binAvg = System.nanoTime() - start;

        start = System.nanoTime();
        SequentialBinarySearch.binarySearchById(products, worstCaseId);
        binWorst = System.nanoTime() - start;

        System.out.printf("%-20s %-15s %-15s %-15s%n", "Method", "Best Case(ns)", "Average Case(ns)", "Worst Case(ns)");
        System.out.printf("%-20s %-15d %-15d %-15d%n", "Sequential Search", seqBest, seqAvg, seqWorst);
        System.out.printf("%-20s %-15d %-15d %-15d%n", "Binary Search", binBest, binAvg, binWorst);
    }
}
