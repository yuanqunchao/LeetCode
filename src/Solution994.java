import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
994.腐烂的橘子
 */
public class Solution994 {
    public int orangesRotting(int[][] grid) {
        // 刚腐烂的橘子坐标队列
        Queue<Integer> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        // 将腐烂的橘子坐标加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j);
                }
            }
        }
        // 如果都没有腐烂的橘子，就看是否有新鲜的橘子
        // 如果存在新鲜的橘子就返回-1，如果也没有新鲜的橘子，就返回0
        if (queue.isEmpty()) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return 0;
        }
        int mins = 0;
        while (!queue.isEmpty()) {
            mins++;  // 分钟数+1，进行新一轮的腐蚀
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                int row = pos / n;
                int col = pos % n;
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.offer((row - 1) * n + col);
                }
                if (row + 1 < m && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.offer((row + 1) * n + col);
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.offer(row * n + col - 1);
                }
                if (col + 1 < n && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.offer(row * n + col + 1);
                }
            }
        }
        // 因为只要队列不等于空，就分钟数+1进行新一轮腐蚀，最后队列为空，肯定最后一轮没有腐蚀到新橘子，所以mins--
        mins--;
        // 然后看有没有新鲜橘子，如果还有新鲜橘子，就返回-1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return mins;
    }
}
