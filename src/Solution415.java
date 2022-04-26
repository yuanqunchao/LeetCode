/*
415.字符串相加
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int r = 0;
        while (i >= 0 || j >= 0 || r > 0) {
            int add1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int add2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = add1 + add2 + r;
            stringBuilder.append(sum % 10);
            r = sum / 10;
            i--;
            j--;
        }
        return stringBuilder.reverse().toString();
    }
}
