import java.util.*;

/*
179.最大数
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String num1 = String.valueOf(o1);
                String num2 = String.valueOf(o2);
                return (num1 + num2).compareTo(num2 + num1);
            }
        });
        Collections.reverse(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : list) {
            stringBuilder.append(num);
        }
        if (stringBuilder.charAt(0) == '0') {
            return "0";
        }
        return stringBuilder.toString();
    }
}
