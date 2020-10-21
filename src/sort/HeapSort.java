package sort;

import java.util.Arrays;


/**
 * 堆排序
 */
public class HeapSort {

    public static void sort(int[] a) {
        int n = a.length;

        //建最大堆
        for (int k = n / 2; k >= 0; k--) {
            sink(a, k, n);
        }

        int k = n - 1;
        while (k > 1) {
            exchange(a, 0, k--);
            sink(a, 0, k);
        }
    }

    private static void sink(int[] a, int k, int n) {
        while (2 * k + 1 <= n - 1) {
            int j = 2 * k + 1;
            if (j < n - 1 && a[j] < a[j + 1]) {
                j++;
            }
            if (a[k] > a[j]) {
                break;
            }
            exchange(a, k, j);
            k = j;
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 6, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
