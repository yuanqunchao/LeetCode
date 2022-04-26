import java.util.ArrayList;
import java.util.List;

/*
54.螺旋矩阵
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            if (top <= bottom) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
                if (left <= right) {
                    for (int i = right; i >= left; i--) {
                        list.add(matrix[bottom][i]);
                    }
                    bottom--;
                    if (top <= bottom) {
                        for (int i = bottom; i >= top; i--) {
                            list.add(matrix[i][left]);
                        }
                        left++;
                    }
                }
            }
        }
        return list;
    }
}
