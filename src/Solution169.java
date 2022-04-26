/*
169.多数元素
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int candidates = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidates = nums[i];
                count++;
            } else {
                if (nums[i] == candidates) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidates;
    }
}
