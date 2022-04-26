/*
79.单词搜索
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean find = dfs(board, i, j, word, 0, visited);
                    if (find) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index, int[][] visited) {
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = 1;
        if (i - 1 >= 0 && board[i - 1][j] == word.charAt(index + 1) && visited[i - 1][j] == 0) {
            boolean find = dfs(board, i - 1, j, word, index + 1, visited);
            if (find) return true;
            visited[i - 1][j] = 0;
        }
        if (i + 1 < board.length && board[i + 1][j] == word.charAt(index + 1) && visited[i + 1][j] == 0) {
            boolean find = dfs(board, i + 1, j, word, index + 1, visited);
            if (find) return true;
            visited[i + 1][j] = 0;
        }
        if (j - 1 >= 0 && board[i][j - 1] == word.charAt(index + 1) && visited[i][j - 1] == 0) {
            boolean find = dfs(board, i, j - 1, word, index + 1, visited);
            if (find) return true;
            visited[i][j - 1] = 0;
        }
        if (j + 1 < board[0].length && board[i][j + 1] == word.charAt(index + 1) && visited[i][j + 1] == 0) {
            boolean find = dfs(board, i, j + 1, word, index + 1, visited);
            if (find) return true;
            visited[i][j + 1] = 0;
        }
        visited[i][j] = 0;
        return false;
    }
}
