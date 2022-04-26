/*
240.搜索二维矩阵
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (target == matrix[x][y]) {
                return true;
            } else if (target > matrix[x][y]) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
