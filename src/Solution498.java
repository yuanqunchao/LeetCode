public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int pos = 0;

        int i = 0;
        int j = 0;
        int direction = 1;  // 向上
        while (i < m && j < n) {
            if (direction == 1) {  // 如果是向上走
                while (true) {
                    ans[pos++] = mat[i][j];
                    if (i == 0 || j == n - 1) {
                        break;
                    }
                    i--;
                    j++;
                }
                direction = 0;
                if (j < n - 1) {
                    j++;
                } else {
                    i++;
                }
            } else {  // 如果是向下的方向
                while (true) {
                    ans[pos++] = mat[i][j];
                    if (j == 0 || i == m - 1) {
                        break;
                    }
                    i++;
                    j--;
                }
                direction = 1;
                if (i < m - 1) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}
