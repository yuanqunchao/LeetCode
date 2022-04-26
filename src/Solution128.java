import java.util.HashSet;
import java.util.Set;

/*
128.最长连续序列
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {  // 遍历set集合
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                longest = Math.max(longest, currentLen);
            }
        }
        return longest;
    }
}
