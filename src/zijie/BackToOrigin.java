package zijie;

/*
圆环回原点问题
圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法
 */
public class BackToOrigin {
    static int k = 0;

    // current代表当前的位置，n代表还可以走的步数
    public static void dfs(int current, int n) {
        // 如果当前位置为0并且没有步数了，就算找到了一种走法
        if (current == 0 && n == 0) {
            k++;
            return;
        }
        // 如果剩余步数为0，就直接return
        if (n == 0) {
            return;
        }
        // 向右走一步，然后步数-1
        dfs((current + 1) % 10, n - 1);
        // 向左走一步，然后步数-1
        dfs((current - 1 + 10) % 10, n - 1);
    }


    public static void main(String[] args) {
        dfs(0, 4);
        System.out.println(k);
    }
}
