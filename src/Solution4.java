/*
4.寻找两个正序数组的中位数
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 == 1) {  // 如果是奇数的话
            int mid = total / 2;
            return getKthMin(nums1, nums2, mid + 1);
        } else {
            int mid1 = total / 2 - 1;
            int mid2 = total / 2;
            return (getKthMin(nums1, nums2, mid1 + 1) + getKthMin(nums1, nums2, mid2 + 1)) / 2;
        }
    }

    // 求第K小的数
    public double getKthMin(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int begin1 = 0;
        int begin2 = 0;
        while (true) {
            // 边界情况
            if (begin1 == m) {
                return nums2[begin2 + k - 1];
            }
            if (begin2 == n) {
                return nums1[begin1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[begin1], nums2[begin2]);
            }
            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(begin1 + half - 1, m - 1);
            int newIndex2 = Math.min(begin2 + half - 1, n - 1);
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - begin1 + 1);
                begin1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - begin2 + 1);
                begin2 = newIndex2 + 1;
            }
        }
    }
}
