/*
剑指Offer40.最小的k个数
 */
public class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 调整为最小堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[0];
            swap(arr, 0, arr.length - i - 1);
            adjust(arr, 0, arr.length - i - 1);
        }
        return ans;
    }

    public void adjust(int[] arr, int i, int length) {
        for (int k = 2 * i + 1; k < length; k = 2 * i + 1) {
            if (k + 1 < length && arr[k + 1] < arr[k]) {  // 找出小的那个孩子
                k++;
            }
            if (arr[i] > arr[k]) {
                swap(arr, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
