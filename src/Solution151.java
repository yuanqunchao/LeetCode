import java.util.*;

/*
151.颠倒字符串中的单词
 */
public class Solution151 {
    public static String reverseWords(String s) {
        s = s.trim();
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                stringBuilder.append(s.charAt(i));
            } else {
                if (stringBuilder.length() > 0) {
                    list.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }
            }
        }
        list.add(stringBuilder.toString());  // 最后肯定会有一个单词没有加进去
        Collections.reverse(list);
        stringBuilder.setLength(0);
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            if (i != list.size() - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
