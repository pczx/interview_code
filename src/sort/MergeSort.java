package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    private int[] aux;

    public void sort(int[] a) {
        aux = new int[a.length];
        mergeSort(a, 0, a.length - 1);
    }

    //自底向上merge
    public void sortBU(int[] a) {
        aux = new int[a.length];
        int n = a.length;
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len + len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, n - 1);
                merge(a, lo, mid, hi);
            }
        }
    }

    public void mergeSort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private void merge(int[] a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] > aux[j]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 6, 3, 2, 1};
//        new MergeSort().sort(a);
        new MergeSort().sortBU(a);
        System.out.println(Arrays.toString(a));
    }
}