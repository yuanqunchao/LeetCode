package huawei;

public class Jump2End {
    public boolean jumpToEnd(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) {
            int step = nums[i];
            i += step;
        }
        return i == nums.length - 1;
    }
}
