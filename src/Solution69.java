/*
69.x的平方根
 */
public class Solution69 {
    public int mySqrt(int x) {
        /*
        二分查找
         */
        int left = 0, right = x;
        int ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
