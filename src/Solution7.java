/*
7.整数反转
 */
public class Solution7 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;  // 0直接返回
        }
        while (x % 10 == 0) {
            x = x / 10;  // 去掉结尾的0
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (x > 0) {
            long num = Long.parseLong(stringBuilder.append(x).reverse().toString());
            return num > Integer.MAX_VALUE ? 0 : (int) num;
        } else {
            String s = String.valueOf(x);
            s = s.substring(1);  // 去掉符号
            long num = Long.parseLong(stringBuilder.append(s).reverse().toString());
            return num > -(long) Integer.MIN_VALUE ? 0 : -(int) num;
        }
    }
}
