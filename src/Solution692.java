import java.util.*;

public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 如果出现次数一样的话，按照字母排序
                return map.get(o1) == map.get(o2) ? o1.compareTo(o2) : map.get(o2) - map.get(o1);
            }
        });
        return list.subList(0, k);
    }
}
