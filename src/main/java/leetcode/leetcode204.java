package leetcode;

public class leetcode204 {
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isPrimes(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
