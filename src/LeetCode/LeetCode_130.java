package LeetCode;

/**
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class LeetCode_130 {
    /**
     * 思路：
     * 这道题我们拿到基本就可以确定是图的 dfs、bfs 遍历的题目了。
     * 题目中解释说被包围的区间不会存在于边界上，所以我们会想到边界上的 O 要特殊处理，
     * 只要把边界上的 O 特殊处理了，那么剩下的 O 替换成 X 就可以了。
     * 问题转化为，如何寻找和边界联通的 O，我们需要考虑如下情况。
     * X X X X
     * X O O X
     * X X O X
     * X O O X
     * 这时候的 O 是不做替换的。因为和边界是连通的。
     * 为了记录这种状态，我们把这种情况下的 O 换成 # 作为占位符，
     * 待搜索结束之后，遇到 O 替换为 X（和边界不连通的 O）；遇到 #，替换回 $O(和边界连通的 O)。
     *
     * dfs递归:
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘o开始搜索
                boolean flag = (i == 0 || j == 0 || i == m - 1 || j == n - 1);
                if(flag && board[i][j] == 'O') {
                    dfs(board, i , j);
                }
            }
        }
        // 搜索完替换
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        // board[i][j] == '#' 说明已经搜索过了.
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
