/*
394.字符串解码
 */
public class Solution394 {
    int k = 0;

    public String decodeString(String s) {
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        while (k < s.length()) {
            if (Character.isDigit(s.charAt(k))) {  // 如果是数字
                int num = getDigit(s);
                k++;  // 跳过[
                String subS = decode(s);
                for (int i = 0; i < num; i++) {
                    stringBuilder.append(subS);
                }
            } else if (s.charAt(k) == ']') {
                k++;
                break;
            } else {
                stringBuilder.append(s.charAt(k++));
            }
        }
        return stringBuilder.toString();
    }

    public int getDigit(String s) {
        int ans = 0;
        while (k < s.length() && Character.isDigit(s.charAt(k))) {
            ans = ans * 10 + s.charAt(k) - '0';
            k++;
        }
        return ans;
    }


}
