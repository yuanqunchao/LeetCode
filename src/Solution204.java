import java.util.Arrays;

/*
204.计算质数
 */
public class Solution204 {
    public int countPrimes(int n) {
        int[] isPrimes = new int[n];
        Arrays.fill(isPrimes, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrimes[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
