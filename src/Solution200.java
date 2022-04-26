/*
200.岛屿数量
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        int islandNums = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] seen = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && seen[i][j] == 0) {
                    islandNums++;
                    dfs(grid, seen, i, j);
                }
            }
        }
        return islandNums;
    }

    public void dfs(char[][] grid, int[][] seen, int i, int j) {
        seen[i][j] = 1;
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && seen[i - 1][j] == 0) {
            dfs(grid, seen, i - 1, j);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1' && seen[i + 1][j] == 0) {
            dfs(grid, seen, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && seen[i][j - 1] == 0) {
            dfs(grid, seen, i, j - 1);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1' && seen[i][j + 1] == 0) {
            dfs(grid, seen, i, j + 1);
        }
    }

}
