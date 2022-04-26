import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
239.滑动窗口最大值
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxWindow = new int[nums.length - k + 1];
        int pos = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        maxWindow[pos++] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            if (i - k == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            maxWindow[pos++] = nums[deque.peekFirst()];
        }
        return maxWindow;
    }
}
