/*
695.岛屿的最大面积
 */
public class Solution695 {
    int maxArea = 0;
    int currentArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    currentArea = 0;
                    dfs(grid, i, j, visited);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }

    public void dfs(int[][] grid, int i, int j, int[][] visited) {
        visited[i][j] = 1;
        currentArea++;
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && visited[i - 1][j] == 0) {
            dfs(grid, i - 1, j, visited);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1 && visited[i + 1][j] == 0) {
            dfs(grid, i + 1, j, visited);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && visited[i][j - 1] == 0) {
            dfs(grid, i, j - 1, visited);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1 && visited[i][j + 1] == 0) {
            dfs(grid, i, j + 1, visited);
        }
    }
}
