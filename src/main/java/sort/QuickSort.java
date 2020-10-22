package sort;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;  // a[lo..j-1] <= a[j] <= a[j+1..hi]
    }


    public static void quickSort(int[] a) {
        quick3way(a, 0, a.length - 1);
    }

    public static void quick3way(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo, i = lo + 1, gt = hi;
        int v = a[lo];
        while (i <= gt) {
            if (a[i] < v) exchange(a, lt++, i++);
            else if (a[i] > v)  exchange(a, i, gt--);
            else i++;
        }  // a[lo..lt-1] <= v <= a[lt..gt] <= a[gt+1..hi]
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }


    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 6, 3, 2, 1};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
