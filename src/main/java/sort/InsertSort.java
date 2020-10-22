package sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 6, 3, 2, 1};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
