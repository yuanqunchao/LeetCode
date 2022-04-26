package huawei;

public class Jump2End {
    // 1
    public boolean jumpToEnd(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) {
            int step = nums[i];
            i += step;
        }
        return i == nums.length - 1;
    }
}
