import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
554.砖墙
 */
public class Solution554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int nums = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                nums += wall.get(i).get(j);
                map.put(nums, map.getOrDefault(nums, 0) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return wall.size() - max;
    }
}
