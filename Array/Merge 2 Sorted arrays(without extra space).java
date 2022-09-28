import java.util.Scanner;

public class MergeSortedArraysWithoutExtraSpace {
    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        for (int i = n - 1; i >= 0; i--) {
            
            int lastEle = arr1[m - 1], j;
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }
            if (j == m - 2 && lastEle > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = lastEle;
            } else if (j != m - 2 && lastEle > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = lastEle;
            }
        }
    }
}
