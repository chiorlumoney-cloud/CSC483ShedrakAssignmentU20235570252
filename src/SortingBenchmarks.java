import java.util.*;

public class SortingBenchmarks {

    public static void insertionSort(Product[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Product key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getProductId() > key.getProductId()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
